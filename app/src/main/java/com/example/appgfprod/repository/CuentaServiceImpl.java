package com.example.appgfprod.repository;

import com.example.appgfprod.converter.CuentaConverter;
import com.example.appgfprod.database.AppExecutors;
import com.example.appgfprod.database.dao.CuentaDao;
import com.example.appgfprod.dto.CuentaDto;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CuentaServiceImpl implements CuentaService {
    private final CuentaDao cuentaDao;
    private List<CuentaDto> lastCuentas;
    private CuentaDto cuenta;
    private CuentaConverter cuentaConverter = new CuentaConverter();
    private int idLastInserted;

    public CuentaServiceImpl(CuentaDao cuentaDao) {
        this.cuentaDao = cuentaDao;
    }

    @Override
    public List<CuentaDto> getAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<CuentaDto>> result = executor.submit(new Callable<List<CuentaDto>>() {
            public List<CuentaDto> call() throws Exception {
                return cuentaConverter.mapListEntityToListDto(cuentaDao.getAll());
            }
        });
        try {
            lastCuentas = result.get();
        } catch (Exception exception) {
        }
        return lastCuentas;
    }

    @Override
    public CuentaDto getCuentaById(int id) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<CuentaDto> result = executor.submit(new Callable<CuentaDto>() {
            public CuentaDto call() throws Exception {
                return cuentaConverter.mapEntityToDto(cuentaDao.findById(id));
            }
        });
        try {
            cuenta = result.get();
        } catch (Exception exception) {
        }
        return cuenta;
    }

    @Override
    public int getLastInsertedIdCuenta() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> result = executor.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return cuentaDao.getLastInsertedIdCuenta();
            }
        });
        try {
            idLastInserted = result.get();
        } catch (Exception exception) {
        }
        return idLastInserted;
    }

    @Override
    public void insertOrUpdateCuenta(CuentaDto paisDto) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                cuentaDao.insertCuenta(cuentaConverter.mapDtoToEntity(paisDto));
            }
        });
    }

    @Override
    public void deleteAllCuenta() {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                cuentaDao.deleteAllCuentas();
            }
        });
    }
}
