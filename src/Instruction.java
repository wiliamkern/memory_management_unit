
public class Instruction { // instru��o a ser executada pelo sistema 
	
		public String typeOperation; // sw ou lw (tipo de opera��o a ser executada)
		public String value;
		public int storagePosition;
		public String ES;
		public boolean processado = false;
		//testttSt
		
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
		public String getES() {
			return ES;
		}
		public void setES(String eS) {
			ES = eS;
		}
		
}

