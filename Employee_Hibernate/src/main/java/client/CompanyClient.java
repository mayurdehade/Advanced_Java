package client;

import operation.Operations;

public class CompanyClient {

	public static void main(String[] args) {
		Operations op = new Operations();
		op.batchInsertEmp(2);
		
//		op.displayAllEmp();
//		op.displayEmpAboveGiveSalary(10000.0f);
//		op.displayFirstAndLastName();
//		op.updateEmpInfo(1);
//		op.retrieveEmpById(1);
//		op.searchEmpByLastName("Dehade");
//		op.searchEmpByPartialLastName("ha");
//		op.deleteEmpById(0);
	}

}
