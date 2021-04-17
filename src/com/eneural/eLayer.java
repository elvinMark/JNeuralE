package com.eneural;

import com.emath.*;

public abstract class eLayer{
    public abstract eMatrix forward(eMatrix in);
    public abstract eMatrix backward(eMatrix err);
    public abstract void update(eOptimizer optim);
}
