package com.eneural;

import com.emath.*;

public class eSGDOptimizer extends eOptimizer{
    public eSGDOptimizer(double lr){
	this.type = eOptimizer.OPTIM_SGD;
	this.lr = lr;
    }
}
