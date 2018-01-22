package com.IdeaProjects.StepicExercises;
//Stepic.Step 5.4_Animal
/*
Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal. Массив байт устроен следующим
образом. Сначала идет число типа int, записанное при помощи ObjectOutputStream.writeInt(size). Далее подряд записано
указанное количество объектов типа Animal, сериализованных при помощи ObjectOutputStream.writeObject(animal).
        Если вдруг массив байт не является корректным представлением массива экземпляров Animal, то метод должен бросить
        исключение java.lang.IllegalArgumentException.
        Причины некорректности могут быть разные. Попробуйте подать на вход методу разные некорректные данные и
        посмотрите, какие исключения будут возникать. Вот их-то и нужно превратить в IllegalArgumentException и
        выбросить. Если что-то забудете, то проверяющая система подскажет. Главное не глотать никаких исключений,
        т.е. не оставлять нигде пустой catch.
*/
//заменить Step5_4_Animal на Animal

import java.io.*;
import java.util.Objects;

public class Step5_4_Animal implements Serializable{

    private final String name;

    private Step5_4_Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Step5_4_Animal) {
            return Objects.equals(name, ((Step5_4_Animal) obj).name);
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        Step5_4_Animal [] animals = new Step5_4_Animal[]{new Step5_4_Animal("DOG"),new Step5_4_Animal("CAT"),new Step5_4_Animal("HORSE")};
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeInt(3);
        for (Step5_4_Animal currentAnimal : animals)
        {
            oos.writeObject(currentAnimal);
        }
        oos.close();

        byte[] byteArray = os.toByteArray();
        Step5_4_Animal[] animal2 = deserializeAnimalArray(byteArray);
        System.out.println (animal2.toString());
    }
    private static Step5_4_Animal[] deserializeAnimalArray(byte[] data)  {
        try(ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int val = in.readInt();
            Step5_4_Animal[] currentAnimal  = new Step5_4_Animal[val];

            if(val >= 0) {
                for (int i = 0; i < val; i++) {
                    currentAnimal[i] = (Step5_4_Animal) in.readObject();
                }
            }
            in.close();
            return currentAnimal;
        } catch (IOException e){
            throw new IllegalArgumentException(e);
        }catch (ClassNotFoundException e){
            throw new IllegalArgumentException(e);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
