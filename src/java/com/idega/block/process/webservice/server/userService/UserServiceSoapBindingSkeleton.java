/**
 * UserServiceSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server.userService;

public class UserServiceSoapBindingSkeleton implements com.idega.block.process.webservice.server.userService.UserService, org.apache.axis.wsdl.Skeleton {
    private com.idega.block.process.webservice.server.userService.UserService impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        //org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getUserInfo", _params, new javax.xml.namespace.QName("", "getUserInfoReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "UserInfo"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "getUserInfo"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getUserInfo") == null) {
            _myOperations.put("getUserInfo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getUserInfo")).add(_oper);
    }

    public UserServiceSoapBindingSkeleton() {
        this.impl = new com.idega.block.process.webservice.server.userService.UserServiceSoapBindingImpl();
    }

    public UserServiceSoapBindingSkeleton(com.idega.block.process.webservice.server.userService.UserService impl) {
        this.impl = impl;
    }
    public com.idega.block.process.webservice.server.userService.UserInfo getUserInfo(java.lang.String in0) throws java.rmi.RemoteException
    {
        com.idega.block.process.webservice.server.userService.UserInfo ret = impl.getUserInfo(in0);
        return ret;
    }

}
