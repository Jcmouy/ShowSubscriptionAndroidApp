package com.example.appgfprod.view.fragment;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.appgfprod.R;
import com.example.appgfprod.adapter.CatalogoRecyclerAdapter;
import com.example.appgfprod.dto.ObraDto;
import com.example.appgfprod.helper.PrefManager;
import com.example.appgfprod.repository.ObraService;
import com.example.appgfprod.util.constants.ConstantMenuFrag;
import com.example.appgfprod.view.model.Injection;
import com.example.appgfprod.view.transition.DetailsTransition;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.transition.platform.Hold;
import com.google.android.material.transition.platform.MaterialElevationScale;
import com.google.android.material.transition.platform.MaterialFadeThrough;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DashboardFragment extends Fragment implements  CatalogoRecyclerAdapter.ItemClickListener{
    private List<ObraDto> obraList;
    private RecyclerView recyclerView;
    private FrameLayout coordinatorLayout;
    private CatalogoRecyclerAdapter mAdapter;
    private PrefManager pref;
    private HandleFragment handleFrag;
    private ObraService obraService;

    public DashboardFragment() {
    }

    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        obraService = Injection.provideObraService(requireContext());
        setEnterTransition(new MaterialFadeThrough().setDuration(300L));
        handleFrag = new HandleFragment(requireActivity().getSupportFragmentManager());

        obraList = obraService.getAll();
        pref = new PrefManager(getActivity());

        if (pref.isFirstTimeLaunch()) {
            pref.setFirstTimeLaunch(false);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        postponeEnterTransition();

        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                startPostponedEnterTransition();
                return true;
            }
        });

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        initCollapsingToolbar(view);

        recyclerView = view.findViewById(R.id.recycler);
        mAdapter = new CatalogoRecyclerAdapter(requireContext(), obraList, this);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(requireContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(2), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        try {
            Glide.with(this).load(R.drawable.catalogo_menu).into((ImageView) view.findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initCollapsingToolbar(View view) {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Catálogo");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    public void onItemClick(int position, CatalogoRecyclerAdapter.MyViewHolder holder) {
        ObraDto item = obraList.get(position);
        Toast.makeText(requireActivity(), item.getNombre(), Toast.LENGTH_SHORT).show();

        ObraDetailFragment obraDetails = ObraDetailFragment.newInstance(obraList.get(position));

        setExitTransition(new Hold().setDuration(300L));
        setReenterTransition(new MaterialElevationScale(true).setDuration(300L));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            obraDetails.setSharedElementEnterTransition(new DetailsTransition());
            obraDetails.setEnterTransition(new Fade());
            setExitTransition(new Fade());
            obraDetails.setSharedElementReturnTransition(new DetailsTransition());
        }

        handleFrag.addFragmentToList(ConstantMenuFrag.CHILD_OBRA_DETAIL) ;

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .addSharedElement(holder.image_obra, "obraImage")
                .replace(R.id.main_frame_container, obraDetails, ConstantMenuFrag.CHILD_OBRA_DETAIL)
                .addToBackStack(null)
                .commit();

    }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }

    }
}