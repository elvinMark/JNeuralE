package com.eneural;

import com.emath.*;

public class eAdaGradOptimizer extends eOptimizer{
    public eAdaGradOptimizer(double lr){
	this.lr = lr;
	this.type = eOptimizer.OPTIM_ADAGRAD;
    }
}
