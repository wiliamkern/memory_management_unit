
public class Instruction { // instrução a ser executada pelo sistema 
	
		public String typeOperation; // sw ou lw (tipo de operação a ser executada)
		public String value;
		public int storagePosition;
		//testttSS
		
		public String getTypeOperation() {
			return typeOperation;
		}
		public void setTypeOperation(String typeOperation) {
			this.typeOperation = typeOperation;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public int getStoragePosition() {
			return storagePosition;
		}
		public void setStoragePosition(int storagePosition) {
			this.storagePosition = storagePosition;
		}
		
}

