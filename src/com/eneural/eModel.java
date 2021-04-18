package com.eneural;

import com.emath.*;
import java.util.*;

public abstract class eModel{
    public abstract eMatrix forward(eMatrix in);
    public abstract void backward(eMatrix err);
    public abstract void update(eOptimizer optim);
    public abstract ArrayList<Double> train(ArrayList<eMatrix[]> ds,int epochs,eLoss loss,eOptimizer optim);
}
