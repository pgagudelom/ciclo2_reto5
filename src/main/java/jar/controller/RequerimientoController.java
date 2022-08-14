package jar.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import jar.model.dao.AsesorPorCiudadDao;
import jar.model.dao.CompraPorProveedorDao;
import jar.model.dao.ProyectoCasaCampestreDao;
import jar.model.vo.AsesorPorCiudadVo;
import jar.model.vo.CompraPorProveedorVo;
import jar.model.vo.ProyectoCasaCampestreVo;

public class RequerimientoController {

    private final AsesorPorCiudadDao asesorPorCiudadDao;
    private final ProyectoCasaCampestreDao proyectoCasaCampestreDao;
    private final CompraPorProveedorDao compraPorProveedorDao;

    public RequerimientoController(){
        asesorPorCiudadDao = new AsesorPorCiudadDao();
        proyectoCasaCampestreDao = new ProyectoCasaCampestreDao();
        compraPorProveedorDao = new CompraPorProveedorDao();
    }

    public ArrayList<AsesorPorCiudadVo> consultarAsesorPorCiudad() throws SQLException{
        return asesorPorCiudadDao.listar();
    }

    public ArrayList<ProyectoCasaCampestreVo> consultarProyectoCasaCampestre() throws SQLException{
        return proyectoCasaCampestreDao.listar();
    }


    public ArrayList<CompraPorProveedorVo> consultarCompraPorProveedor() throws SQLException{
        return compraPorProveedorDao.listar();
    }
    
}
