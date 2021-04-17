package com.emath;

import java.util.function.*;

public class eMatrix{
    public int rows;
    public int cols;
    public double[][] data;

    public eMatrix(int rows, int cols){
	this.rows = rows;
	this.cols = cols;
	this.data = new double[rows][cols];

	for(int i = 0;i<this.rows;i++)
	    for(int j = 0;j<this.cols;j++)
		this.data[i][j] = 0;
    }

    public eMatrix(int rows, int cols, double[][] data){
	this.rows = rows;
	this.cols = cols;
	this.data = data;
    }
    
    public void random(){
	for(int i = 0;i<this.rows;i++)
	    for(int j = 0;j<this.cols;j++)
		this.data[i][j] = Math.random();
    }

    public void print(){
	for(int i = 0;i<this.rows;i++){
	    for(int j = 0;j<this.cols;j++)
		System.out.print(this.data[i][j] + " ");
	    System.out.println("");
	}
	System.out.println("");
    }
    
    public eMatrix plus(eMatrix M){
	eMatrix out = new eMatrix(this.rows,this.cols);
	if(this.rows == M.rows && this.cols == M.cols){
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][j] = this.data[i][j] + M.data[i][j];
	}
	else if(M.rows == 1){
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][j] = this.data[i][j] + M.data[0][j];
	}
	else if(M.cols == 1){
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][j] = this.data[i][j] + M.data[i][0];
	}
	return out;
    }

    public eMatrix plus(double num){
	eMatrix out = new eMatrix(this.rows,this.cols);
	for(int i = 0;i<this.rows;i++)
	    for(int j = 0;j<this.cols;j++)
		out.data[i][j] = this.data[i][j] + num;
	return out;
    }

    
    public eMatrix minus(eMatrix M){
	eMatrix out = new eMatrix(this.rows,this.cols);
	if(this.rows == M.rows && this.cols == M.cols){
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][j] = this.data[i][j] - M.data[i][j];
	}
	else if(M.rows == 1){
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][j] = this.data[i][j] - M.data[0][j];
	}
	else if(M.cols == 1){
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][j] = this.data[i][j] - M.data[i][0];
	}
	return out;
    }

    public eMatrix minus(double num){
	eMatrix out = new eMatrix(this.rows,this.cols);
	for(int i = 0;i<this.rows;i++)
	    for(int j = 0;j<this.cols;j++)
		out.data[i][j] = this.data[i][j] - num;
	return out;
    }

    public eMatrix times(eMatrix M){
	eMatrix out = new eMatrix(this.rows,this.cols);
	if(this.rows == M.rows && this.cols == M.cols){
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][j] = this.data[i][j] * M.data[i][j];
	}
	else if(M.rows == 1){
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][j] = this.data[i][j] * M.data[0][j];
	}
	else if(M.cols == 1){
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][j] = this.data[i][j] * M.data[i][0];
	}
	return out;
    }

    public eMatrix times(double num){
	eMatrix out = new eMatrix(this.rows,this.cols);
	for(int i = 0;i<this.rows;i++)
	    for(int j = 0;j<this.cols;j++)
		out.data[i][j] = this.data[i][j] * num;
	return out;
    }

    public eMatrix div(eMatrix M){
	eMatrix out = new eMatrix(this.rows,this.cols);
	if(this.rows == M.rows && this.cols == M.cols){
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][j] = this.data[i][j] / M.data[i][j];
	}
	else if(M.rows == 1){
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][j] = this.data[i][j] / M.data[0][j];
	}
	else if(M.cols == 1){
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][j] = this.data[i][j] / M.data[i][0];
	}
	return out;
    }

    public eMatrix div(double num){
	eMatrix out = new eMatrix(this.rows,this.cols);
	for(int i = 0;i<this.rows;i++)
	    for(int j = 0;j<this.cols;j++)
		out.data[i][j] = this.data[i][j] / num;
	return out;
    }

    public eMatrix dot(eMatrix M){
	eMatrix out = new eMatrix(this.rows,M.cols);
	double s = 0;
	for(int i = 0;i<this.rows;i++){
	    for(int j = 0;j<M.cols;j++){
		s = 0;
		for(int k = 0;k<this.cols;k++)
		    s += this.data[i][k] * M.data[k][j];
		out.data[i][j] = s;
	    }
	}
	return out;
    }

    public eMatrix transpose(){
	eMatrix out = new eMatrix(this.cols,this.rows);
	for(int i = 0;i<this.rows;i++)
	    for(int j = 0;j<this.cols;j++)
		out.data[j][i] = this.data[i][j];
	return out;
    }
    
    public eMatrix applyFunc(DoubleUnaryOperator funf){
	eMatrix out = new eMatrix(this.rows,this.cols);
	for(int i = 0;i<this.rows;i++)
	    for(int j = 0;j<this.cols;j++)
		out.data[i][j] = funf.applyAsDouble(this.data[i][j]);
	return out;
    }

    public eMatrix sum(int axis){
	eMatrix out;
	if(axis == 0){
	    out = new eMatrix(this.rows,1);
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[i][0] += this.data[i][j];
	    return out;
	}
	else if(axis == 1){
	    out = new eMatrix(1,this.cols);
	    for(int i = 0;i<this.rows;i++)
		for(int j = 0;j<this.cols;j++)
		    out.data[0][j] += this.data[i][j];
	    return out;
	}
	return null;	
    }

    public double sum(){
	double s = 0;
	for(int i = 0;i<this.rows;i++)
	    for(int j = 0;j<this.cols;j++)
	        s += this.data[i][j];
	return s;
    }

    public eMatrix getSubMatrix(int offset,int rows){
	double[][] data = new double[rows][];
	int _rows = 0;
        while(_rows + offset < this.rows && _rows < rows){
	    data[_rows] = this.data[_rows + offset];
	    _rows += 1;
	}
	return new eMatrix(_rows,this.cols,data);
    }
}
