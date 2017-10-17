package com.netcracker.homework2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class EntityListOperation implements ListOperation<Entity> {

    @Override
    public void maximumDelete(List<Entity> list) {
        List<Entity> entities = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        for (Entity entity : list) {
            if (entity.getValue() == maxValue) {
                entities.add(entity);
            } else if (entity.getValue() > maxValue) {
                maxValue = entity.getValue();
                entities.clear();
                entities.add(entity);
            }
        }
        list.removeAll(entities);
    }

    @Override
    public void deleteByValue(List<Entity> list, int value) {
        list.removeIf(entity -> entity.getValue() == 3);
    }

    @Override
    public long calculateSum(List<Entity> list) {
        long sum = 0;
        for (Entity entity : list) {
            sum += entity.getValue();
        }
        return sum;
    }

    @Override
    public Entity getThird(List<Entity> list) {
        return list.get(2);
    }

    @Override
    public List<Entity> getTwoFromSecond(List<Entity> list) {
        List<Entity> returnedList = new ArrayList<>();
        returnedList.add(list.get(1));
        returnedList.add(list.get(2));
        return returnedList;
    }

    @Override
    public List<Entity> getAllByTemplate(List<Entity> list) {
        List<Entity> entities = new ArrayList<>();
        for (Entity entity : list) {
            if (entity.getName().length() <= 5) {
                entities.add(entity);
            }
        }
        return entities;
    }

    @Override
    public boolean findSymbolInAllItems(List<Entity> list, Character character) {
        for (Entity entity : list) {
            if (entity.getName().indexOf(character) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addSymbolToName(List<Entity> list) {
        for (Entity entity : list) {
            entity.setName(entity.getName() + "_1");
        }
    }

    @Override
    public void sorted(List<Entity> list) {
        list.sort(Comparator.comparing(Entity::getName));
        list.sort(Comparator.comparing(Entity::getValue));
    }
}
