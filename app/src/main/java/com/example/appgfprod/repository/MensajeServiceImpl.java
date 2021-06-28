package com.example.appgfprod.repository;

import com.example.appgfprod.converter.MensajeConverter;
import com.example.appgfprod.database.AppExecutors;
import com.example.appgfprod.database.dao.MensajeDao;
import com.example.appgfprod.dto.MensajeDto;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MensajeServiceImpl implements MensajeService {
    private final MensajeDao mensajeDao;
    private MensajeConverter mensajeConverter = new MensajeConverter();
    private List<MensajeDto> lastMensajes;
    private MensajeDto mensaje;
    private Integer idLastInserted;

    public MensajeServiceImpl(MensajeDao mensajeDao) {
        this.mensajeDao = mensajeDao;
    }

    @Override
    public List<MensajeDto> getAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<MensajeDto>> result = executor.submit(new Callable<List<MensajeDto>>() {
            public List<MensajeDto> call() throws Exception {
                return mensajeConverter.mapListEntityToListDto(mensajeDao.getAll());
            }
        });
        try {
            lastMensajes = result.get();
        } catch (Exception exception) {
        }
        return lastMensajes;
    }

    @Override
    public List<MensajeDto> getAllMensajeByObra(String nombre) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<MensajeDto>> result = executor.submit(new Callable<List<MensajeDto>>() {
            public List<MensajeDto> call() throws Exception {
                return mensajeConverter.mapListEntityToListDto(mensajeDao.getAllMensajeByObra(nombre));
            }
        });
        try {
            lastMensajes = result.get();
        } catch (Exception exception) {
        }
        return lastMensajes;
    }

    @Override
    public MensajeDto getMensajeById(int id) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<MensajeDto> result = executor.submit(new Callable<MensajeDto>() {
            public MensajeDto call() throws Exception {
                return mensajeConverter.mapEntityToDto(mensajeDao.findById(id));
            }
        });
        try {
            mensaje = result.get();
        } catch (Exception exception) {
        }
        return mensaje;
    }

    @Override
    public int getLastInsertedIdMensaje() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> result = executor.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return mensajeDao.getLastInsertedIdMensaje();
            }
        });
        try {
            idLastInserted = result.get();
        } catch (Exception exception) {
        }
        return idLastInserted;
    }

    @Override
    public void insertOrUpdateMensaje(MensajeDto mensajeDto) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mensajeDao.insertMensaje(mensajeConverter.mapDtoToEntity(mensajeDto));
            }
        });
    }

    @Override
    public void deleteAllMensaje() {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mensajeDao.deleteAllMensajes();
            }
        });
    }
}
