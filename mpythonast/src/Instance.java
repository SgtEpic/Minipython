public class Instance extends Symbol{
    private Clazz clazz;

    public Instance(String name, Clazz clazz){
        super(name);
        this.clazz = clazz;
    }

    public Clazz getClazz(){
        return this.clazz;
    }
}
