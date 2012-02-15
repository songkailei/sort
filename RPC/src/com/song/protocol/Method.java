package com.song.protocol;

import java.io.Serializable;

public class Method  implements Serializable{
	
	public String methodName;
	public Class[] params;
	
	public Method(String name,Class<?>[] parameterType )
	{
		this.methodName = name;
		this.params = parameterType;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Class[] getParams() {
		return params;
	}

	public void setParams(Class[] params) {
		this.params = params;
	}

}
