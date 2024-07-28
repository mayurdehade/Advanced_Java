package service;

import operations.Operations;

public class EmployeeClient {

	public static void main(String[] args) {
		Operations.addEmp();
//		Operations.displayAllEmp();
//		Operations.updateEmp();
//		Operations.deleteEmpRecord();
//		Operations.displayEmpsByIds();
		Operations.totalEmp();
		Operations.displayLimitedEmp();
	}

}
