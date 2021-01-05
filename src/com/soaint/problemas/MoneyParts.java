package com.soaint.problemas;

import java.util.ArrayList;

public class MoneyParts {
	
	public static String[] monedasReales = {"0.05"," 0.1", "0.2", "0.5", "1", "2", "5", "10", "20", "50", "100", "200"};
	
	public static void main(String ...args) {
		build("10");
	}
	
	public static void build(String montoSoles) {
		System.out.println("Entrada: "+montoSoles);
		int num = (int) (Double.parseDouble(montoSoles)*100);
		
		int monedasConvertidas[]={20000, 10000, 5000, 2000, 1000, 500 ,200, 100, 50, 20, 10, 5};
		int cantidad[]={0,0,0,0,0,0,0,0,0,0,0,0};
		cantidad[0]=num;
		ArrayList<ArrayList<Double>> resultadoList = new ArrayList<ArrayList<Double>>(); 
		ArrayList<Double> listaTemporal = new ArrayList<Double>(); 
		
		for(int i=0;i<monedasConvertidas.length;i++){
		    cantidad[i]=num/monedasConvertidas[i];
		    while(cantidad[i]>0 && cantidad[i]!=num-1){
		        int res=num-(monedasConvertidas[i]*cantidad[i]);
		        for(int j=0;j<monedasConvertidas.length;j++){
		        	if(j>i){
		                cantidad[j]=res/monedasConvertidas[j];
		                res-=monedasConvertidas[j]*cantidad[j];
		            }
		            if(cantidad[j]>0) {
		            	for(int x=1;x<=cantidad[j];x++) {
		            		listaTemporal.add(((double)monedasConvertidas[j])/100);
		            	}
		            }
		        }
		        
		        double sum = 0;
		        for(double d : listaTemporal)
		               sum += d;
		        
		        if(sum==((double)num/100)) 
		        	resultadoList.add(listaTemporal);
		        
		        listaTemporal = new ArrayList<Double>();
		        cantidad[i]--;
		    }
		}
		System.out.println("----------------------------");
		System.out.println("Salida: "+resultadoList);
	}

}
