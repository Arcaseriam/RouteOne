
public class Species {
    private String name;
    private ExpCurve curve;
    private Type type1;
    private Type type2;
    private int baseHP;
    private int baseAtk;
    private int baseDef;
    private int baseSpc;
    private int baseSpd;
    private int killExp;
    private int pokedexNum;
    
    private static Species[] allSpecies;
    
    public Species(String s_name, ExpCurve s_curve, Type s_type1, Type s_type2,
            int s_baseHP, int s_baseAtk, int s_baseDef, int s_baseSpc,
            int s_baseSpd, int s_killExp, int s_pokedexNum) {
        name = s_name;
        curve = s_curve;
        type1 = s_type1;
        type2 = s_type2;
        baseHP = s_baseHP;
        baseAtk = s_baseAtk;
        baseDef = s_baseDef;
        baseSpc = s_baseSpc;
        baseSpd = s_baseSpd;
        killExp = s_killExp;
        pokedexNum = s_pokedexNum;
    }
    
    //initialize allSpecies to be a list of all species
    static {
        allSpecies = new Species[Constants.numPokes + 1];
        Species s; Type[] ts;
        for(int i = 0; i < allSpecies.length; i++) {
            //s = new Species();
            String s_name = Constants.poke_names[i];
            ExpCurve s_curve = Constants.exp_curves[i];
            ts = Constants.poke_types[i];
            Type s_type1, s_type2;
            if(ts.length == 0) {
                s_type1 = Type.NONE;
                s_type2 = Type.NONE;
            } else if(ts.length == 1) {
                s_type1 = ts[0];
                s_type2 = Type.NONE;
            } else {
                s_type1 = ts[0];
                s_type2 = ts[1];
            }
            int s_baseHP = Constants.basestats[i][0];
            int s_baseAtk = Constants.basestats[i][1];
            int s_baseDef = Constants.basestats[i][2];
            int s_baseSpd = Constants.basestats[i][3];
            int s_baseSpc = Constants.basestats[i][4];
            int s_killExp = Constants.killexps[i];
            int s_pokedexNum = i;
            
            s = new Species(s_name, s_curve, s_type1, s_type2, s_baseHP, s_baseAtk, 
                    s_baseDef, s_baseSpc, s_baseSpd, s_killExp, s_pokedexNum);
            allSpecies[i] = s;
        }
    }
    
    //returns the species object corresponding to the pokemon with pokedex number i
    public static Species getSpecies(int i) {
        if(i < 0 || i >= allSpecies.length)
            return null;
        return allSpecies[i];
    }
    
    public String toString() {
        return String.format("%d %s %s %s%s Stats: %d %d %d %d %d Exp: %d", pokedexNum, name, curve, type1,
                ((type2 == Type.NONE) ? "" : " " + type2), baseHP, baseAtk, baseDef, baseSpd,
                baseSpc, killExp);
        //return name + " " + curve + " " + type1 + ((type2 == Type.NONE) ? "" : " " + type2) + " ";
    }
    
    public String getName() {
        return name;
    }
    public ExpCurve getCurve() {
        return curve;
    }
    public Type getType1() {
        return type1;
    }
    public Type getType2() {
        return type2;
    }
    public int getBaseHP() {
        return baseHP;
    }
    public int getBaseAtk() {
        return baseAtk;
    }
    public int getBaseDef() {
        return baseDef;
    }
    public int getBaseSpc() {
        return baseSpc;
    }
    public int getBaseSpd() {
        return baseSpd;
    }
    public int getKillExp() {
        return killExp;
    }
    public int getPokedexNum() {
        return pokedexNum;
    }
}
