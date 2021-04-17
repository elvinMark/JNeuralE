package com.eneural;

import com.emath.*;

public abstract class eLoss{
    public eMatrix grad;
    public abstract double calculateLoss(eMatrix o, eMatrix t);
    public abstract eMatrix getGrad();
}
