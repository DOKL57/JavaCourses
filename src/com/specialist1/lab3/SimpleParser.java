package com.specialist1.lab3;

public class SimpleParser extends ComLineParser {

    private String inFile;
    private String outFile;

    public String getInFile() {
        return inFile;
    }

    public String getOutFile() {
        return outFile;
    }

    public SimpleParser(String[] keys) {
        super(keys);
    }

    public SimpleParser(String[] keys, String[] delimeters) {
        super(keys, delimeters);
    }



    @Override
    protected void OnUsage(String errorKey){
        if (errorKey != null)
            System.out.println("Command-line switch error:" + errorKey);

        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
	System.out.println("   -?  показать Help файл");
	System.out.println("   -r  задать имя входного файла");
	System.out.println("   -w  выполнить вывод в указанный файл");
    }

    @Override
    protected SwitchStatus OnSwitch(String key, String keyValue) {
        SwitchStatus status = SwitchStatus.NoError;
        switch (key){
            case ("?"):
                status = SwitchStatus.ShowUsage; break;
            case ("r"):
                if(keyValue.length()<1){
                    status = SwitchStatus.Error;
                    System.out.println("ERROR, IN keyValue is null");
                }
                else{
                    inFile = keyValue;
                }
                break;
            case ("w"):
                if(keyValue.length()<1){
                    status = SwitchStatus.Error;
                    System.out.println("ERROR, OUT keyValue is null");
                }
                else{
                    outFile = keyValue;
                }
                break;
            default:
                status = SwitchStatus.Error; break;
        }
        return status;
    }


}
