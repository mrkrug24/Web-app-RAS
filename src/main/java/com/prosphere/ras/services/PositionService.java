package com.prosphere.ras.services;
import com.prosphere.ras.models.*;
import com.prosphere.ras.DAO.PositionDAO;

public class PositionService extends CommonService<Position, PositionDAO> {
    public PositionService(){
        super(new PositionDAO());
    }
}