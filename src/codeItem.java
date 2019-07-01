public class codeItem {
        public char Zeichen;
        public boolean gefunden;

        public codeItem() {
            this.Zeichen = '_';
            this.gefunden = false;
        }

        public codeItem(char zeichen, boolean value) {
            this.Zeichen = zeichen;
            this.gefunden = value;
        }
        public static void main(String[] args){
            codeItem eins = new codeItem();
            System.out.println(eins.toString());
        }
}
