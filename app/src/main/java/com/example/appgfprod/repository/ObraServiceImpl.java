package com.example.appgfprod.repository;

import com.example.appgfprod.converter.ObraConverter;
import com.example.appgfprod.database.AppExecutors;
import com.example.appgfprod.database.dao.ObraDao;
import com.example.appgfprod.dto.ObraDto;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ObraServiceImpl implements ObraService {
    private final ObraDao obraDao;
    private List<ObraDto> lastObras;
    private ObraDto obra;
    private ObraConverter obraConverter = new ObraConverter();

    public ObraServiceImpl(ObraDao obraDao) {
        this.obraDao = obraDao;
    }

    @Override
    public List<ObraDto> getAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<ObraDto>> result = executor.submit(new Callable<List<ObraDto>>() {
            public List<ObraDto> call() throws Exception {
                return obraConverter.mapListEntityToListDto(obraDao.getAll());
            }
        });
        try {
            lastObras = result.get();
        } catch (Exception exception) {
        }
        return lastObras;
    }

    @Override
    public ObraDto getObraById(int id) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<ObraDto> result = executor.submit(new Callable<ObraDto>() {
            public ObraDto call() throws Exception {
                return obraConverter.mapEntityToDto(obraDao.findById(id));
            }
        });
        try {
            obra = result.get();
        } catch (Exception exception) {
        }
        return obra;
    }

    @Override
    public ObraDto getObraByNombre(String nombre) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<ObraDto> result = executor.submit(new Callable<ObraDto>() {
            public ObraDto call() throws Exception {
                return obraConverter.mapEntityToDto(obraDao.findByNombre(nombre));
            }
        });
        try {
            obra = result.get();
        } catch (Exception exception) {
        }
        return obra;
    }

    @Override
    public void insertOrUpdateObra(ObraDto obraDto) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                obraDao.insertObra(obraConverter.mapDtoToEntity(obraDto));
            }
        });
    }

    @Override
    public void deleteAllObra() {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                obraDao.deleteAllObras();
            }
        });
    }
}
