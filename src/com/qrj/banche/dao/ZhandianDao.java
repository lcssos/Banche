package com.qrj.banche.dao;

import com.qrj.banche.model.Zhandian;

import java.util.List;

public interface ZhandianDao {
    public void save(Zhandian zhandian);

    public void update(Zhandian zhandian);

    public void delete(Zhandian zhandian);

    public List<Zhandian> findByZhandianName(String zhandian_name);

    public List<Zhandian> findAll();

    public List<Zhandian> findByBancheId(int bancheid);

    public List<Zhandian> findByBancheIdDESC(int bancheid);

    public List<Zhandian> findByZhandianId(int zhandianid);

    public List<Zhandian> findByBancheIdandXuhao(int bancheid, int xuhao);

    public List<Zhandian> findByBancheIdandyincang(int bancheid, int yincang);

    public List<Object[]> callwxgeo(int juli, String openId);

    public List<Object[]> callfujinzd(int juli,String openId,int banchid);

    public List<Object[]> callgeo(int juli,long shebeiId,int banchid);
}
