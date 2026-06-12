public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();
        Dog dog = new Dog();
        dog.bark();
        Puppy puppy = new Puppy();
        puppy.play();
    }
}

class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
    void bark() {
        super.eat();
    }
}

class Puppy extends Dog {
    void play() {
        super.bark();
    }
}