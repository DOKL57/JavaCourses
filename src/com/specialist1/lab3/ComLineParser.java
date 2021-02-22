package com.specialist1.lab3;

public class ComLineParser {
    private String[] keys;           // ключи
    private String[] delimeters;     // разделители  "/", "-"

    protected enum SwitchStatus { NoError, Error, ShowUsage };

    public ComLineParser(String[] keys) {
        this(keys, new String[] { "/", "-" });
    }
    public ComLineParser(String[] keys, String[] delimeters) {
        this.keys = keys;
        this.delimeters   = delimeters;
    }

    protected void OnUsage(String errorKey){

    }

    protected SwitchStatus OnSwitch(String key, String keyValue) {
        return SwitchStatus.Error;
    }

    public Boolean Parse(String[] args) {
        SwitchStatus ss = SwitchStatus.NoError;
        int argNum;
        for (argNum = 0; (ss == SwitchStatus.NoError) && (argNum < args.length); argNum++) {
            boolean isDelimeter = false;
            for (int n = 0; !isDelimeter && (n < delimeters.length); n++) {
                isDelimeter = args[argNum].regionMatches(0, delimeters[n], 0, 1);
            }
            if (isDelimeter) {
                //проверка наличия правильного ключа
                boolean isKey = false;
                int i;
                for (i = 0; !isKey && (i < keys.length); i++) {
                    isKey = args[argNum].toUpperCase().regionMatches(1, keys[i].toUpperCase(), 0, keys[i].length());
                    if (isKey) break;
                }
                if (!isKey) {
                    ss = SwitchStatus.Error;
                    break;
                }
                else {
                    ss = OnSwitch(keys[i].toLowerCase(), args[argNum].substring(1 + keys[i].length()));
                }
            }
            else {
                ss = SwitchStatus.Error;
                break;
            }
        }
        if(ss == SwitchStatus.Error) OnUsage((argNum == args.length) ? null : args[argNum]);
        if (ss == SwitchStatus.ShowUsage)    OnUsage(null);
        return ss == SwitchStatus.NoError;

    }
}
