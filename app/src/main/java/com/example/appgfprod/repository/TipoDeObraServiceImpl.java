package com.example.appgfprod.repository;

import com.example.appgfprod.converter.TipoDeObraConverter;
import com.example.appgfprod.database.AppExecutors;
import com.example.appgfprod.database.dao.TipoDeObraDao;
import com.example.appgfprod.dto.TipoDeObraDto;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TipoDeObraServiceImpl implements TipoDeObraService {
    private final TipoDeObraDao tipoDeObraDao;
    private List<TipoDeObraDto> lastTiposDeObras;
    private TipoDeObraDto tipoDeObra;
    private TipoDeObraConverter tipoDeObraConverter = new TipoDeObraConverter();

    public TipoDeObraServiceImpl(TipoDeObraDao tipoDeObraDao) {
        this.tipoDeObraDao = tipoDeObraDao;
    }

    @Override
    public List<TipoDeObraDto> getAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<TipoDeObraDto>> result = executor.submit(new Callable<List<TipoDeObraDto>>() {
            public List<TipoDeObraDto> call() throws Exception {
                return tipoDeObraConverter.mapListEntityToListDto(tipoDeObraDao.getAll());
            }
        });
        try {
            lastTiposDeObras = result.get();
        } catch (Exception exception) {
        }
        return lastTiposDeObras;
    }

    @Override
    public TipoDeObraDto getTipoDeObraById(int id) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<TipoDeObraDto> result = executor.submit(new Callable<TipoDeObraDto>() {
            public TipoDeObraDto call() throws Exception {
                return tipoDeObraConverter.mapEntityToDto(tipoDeObraDao.findById(id));
            }
        });
        try {
            tipoDeObra = result.get();
        } catch (Exception exception) {
        }
        return tipoDeObra;
    }

    @Override
    public void insertOrUpdateTipoDeObra(TipoDeObraDto tipoDeObraDto) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                tipoDeObraDao.insertTipoDeObra(tipoDeObraConverter.mapDtoToEntity(tipoDeObraDto));
            }
        });
    }

    @Override
    public void deleteAllTipoDeObra() {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                tipoDeObraDao.deleteAllTiposDeObra();
            }
        });
    }
}
