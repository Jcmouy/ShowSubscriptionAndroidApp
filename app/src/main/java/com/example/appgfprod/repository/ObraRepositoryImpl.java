package com.example.appgfprod.repository;


import com.example.appgfprod.database.dao.ObraDao;
import com.example.appgfprod.database.entity.Obra;

import java.util.List;

public class ObraRepositoryImpl implements ObraRepository {
    private final ObraDao obraDao;

    public ObraRepositoryImpl(ObraDao obraDao) {
        this.obraDao = obraDao;
    }

    @Override
    public List<Obra> getAll() {
        return obraDao.getAll();
    }

    @Override
    public Obra getObraById(int id) {
        return obraDao.findById(id);
    }

    @Override
    public void insertOrUpdateObra(Obra obra) {
        obraDao.insertObra(obra);
    }

    @Override
    public void deleteAllObra() {
        obraDao.deleteAllObras();
    }
}
