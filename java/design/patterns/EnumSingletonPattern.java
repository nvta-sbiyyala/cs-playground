/**
 * Using Enum to implement singleton pattern
 * Source: http://keaplogik.blogspot.com/2013/12/the-java-enum-singleton-pattern.html
 */

public class EnumSingletonPattern {
    public static void main(String[] args) {
        AnimalHelperSingleton eAHS1 = AnimalHelperSingleton.INSTANCE;
        AnimalHelperSingleton eAHS2 = AnimalHelperSingleton.INSTANCE;
        assert(eAHS1 == eAHS2);
        assert(eAHS1.buildAnimalList().length == eAHS2.buildAnimalList().length);
    }
}

enum AnimalHelperSingleton {

    INSTANCE;

    private AnimalHelperSingleton() {
        // disable instantiation
    }

    public Animal[] buildAnimalList() {
        final Animal[] animals = new Animal[10];

        animals[0] = new SimpleAnimal(Animal.AnimalClass.MAMMAL, 
                "Dog", true);
        animals[1] = new SimpleAnimal(Animal.AnimalClass.MAMMAL, 
                "Cat", true);
        animals[2] = new SimpleAnimal(Animal.AnimalClass.AMPHIBIAN,
                "Frog", true);
        animals[3] = new SimpleAnimal(Animal.AnimalClass.BIRD,
                "Crow", true);
        animals[4] = new SimpleAnimal(Animal.AnimalClass.BIRD,
                "Cardinal", true);
        animals[5] = new SimpleAnimal(Animal.AnimalClass.ARTHROPOD,
                "Mantis", false);
        animals[6] = new SimpleAnimal(Animal.AnimalClass.ARTHROPOD,
                "Spider", false);
        animals[7] = new SimpleAnimal(Animal.AnimalClass.MAMMAL, 
                "Tiger", true);
        animals[8] = new SimpleAnimal(Animal.AnimalClass.MAMMAL, 
                "Bear", true);
        animals[9] = new SimpleAnimal(Animal.AnimalClass.BIRD, 
                "Owl", true);

        return animals;
    }

}

interface Animal {
    
    public enum AnimalClass {
        MAMMAL,
        BIRD,
        FISH,
        REPTILE,
        AMPHIBIAN,
        ARTHROPOD;
        private AnimalClass(){}
    }

    boolean isVertebrate();

    String getSpecies();
    
    AnimalClass getAnimalClass();
}

class SimpleAnimal implements Animal {

    private final boolean vertebrate;
    private final String species;
    private final AnimalClass animalClass;
    
    public SimpleAnimal(){
       throw new AssertionError("Do not implement generic constructor on SimpleAnimal"); 
    }

    public SimpleAnimal(final AnimalClass animalClass, final String species,
            final boolean vertebrate) {
        this.species = species;
        this.vertebrate = vertebrate;
        this.animalClass = animalClass;
    }

    @Override
    public boolean isVertebrate() {
        return vertebrate;
    }

    @Override
    public String getSpecies() {
        return species;
    }

    @Override
    public AnimalClass getAnimalClass() {
        return animalClass;
    }
    
    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Animal: {\n");
        strBuilder.append("\tClass: ")
                .append(this.getAnimalClass()).append("\n");
        strBuilder.append("\tSpecies: ")
                .append(species).append("\n");
        strBuilder.append("\tVertebrate: ")
                .append(vertebrate).append("\n");
        strBuilder.append("\t};");
        
        return strBuilder.toString();
    }
}
