package com.bitguiders.ocejwcd6;

public class Test {
	
	public static boolean isMatching(int[] data,int[] pattern){
		//found initial match
		boolean isMissing=true;
	patternLoop:
		for(int p:pattern){
			isMissing=true;
			for(int d:data){
				if(p==d){
					isMissing=false;
					continue patternLoop;
				}
			}
			if(isMissing){
				return false;
			}
		}
		return true;
	}
	public static boolean isValid(int[] data,int[] pattern){
		
		if(isMatching(data, pattern) && isMatching(pattern,data)){
		
			int dataIndex=0;
		patternLoop:	
			for(int p:pattern){
				for(int d=dataIndex;d<data.length;d++){
					//search for new data
					if(data[d]!=p){
						System.out.println("new value "+data[d]+" found at index="+d);
						
						//verify if value is already processed
						for(int i=0;i<d;i++){
							if(data[i]==data[d]){
								System.out.println(data[d] +" is already processed at loc= "+i);
								return false;
							}
						}
						dataIndex=d;//save index to move loop onward
						continue patternLoop;
					}
				}
		    }
		return true;
		}else{
			return false;
		}
		
	}

 public static void main(String arg[]){
	 int[] data = {1,2,2,3};
	 int[] pattern = {1,2,3,4};
	 System.out.println(isValid(data,pattern));
	 }
}
