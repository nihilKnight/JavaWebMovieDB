package SQLTemplate;

import exce.NullConditionOptionException;
import util.SQLUtil;

public class Condition {
    enum Opt{
        /** Greater, Less, Not Greater, Not Less, Equal, Not Equal
         ** In, Not In, Exists, Not Exists. */
        G, L, NG, NL, E, NE, IN, NIN, EX, NEX
    }
    // Attribute name.
    public String attri;
    // Condition option.
    public Opt opt;
    // Requirement.
    public String requi;

    public Condition(Opt opt, String attri, String requi) {
        this.attri = attri;
        this.opt = opt;
        this.requi = requi;
    }
    public Condition(Opt opt, SQLUtil.DataInfo di) {
        this.attri = di.attri_name;
        this.opt = opt;
        this.requi = SQLUtil.DataParser(di);
    }
    public Condition(Opt opt, String attri, SelectT st) {
        this.attri = attri;
        this.opt = opt;
        this.requi = "(\n" + st.toSQL() + "\n)";
    }

    @Override
    public String toString() {
        String ret = null;
        try {
            ret = this.attri +
                switch (this.opt) {
                    case G -> " > ";
                    case L -> " < ";
                    case NG -> " <= ";
                    case NL -> " >= ";
                    case E -> " = ";
                    case NE -> " != ";
                    case IN -> " IN ";
                    case NIN -> " NOT IN ";
                    case EX -> " EXISTS";
                    case NEX -> "NOT EXISTS";
                    case default -> throw new NullConditionOptionException();
                } +
                this.requi;
        } catch (NullConditionOptionException ncoe) {
            ncoe.printStackTrace();
        }
        return ret;
    }
}
