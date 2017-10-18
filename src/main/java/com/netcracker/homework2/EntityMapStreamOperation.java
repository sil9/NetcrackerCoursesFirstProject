package com.netcracker.homework2;


import java.util.List;
import java.util.Map;

public class EntityMapStreamOperation implements MapOperation<String, Entity> {

    @Override
    public void deleteByMaxField(Map<String, Entity> map) {
        int num = map.entrySet().stream()
                .mapToInt(entry -> entry.getValue().getValue())
                .max()
                .getAsInt();
        deleteByValue(map, num);
    }

    @Override
    public void deleteByMinField(Map<String, Entity> map) {
        int num = map.entrySet().stream()
                .mapToInt(entry -> entry.getValue().getValue())
                .min()
                .getAsInt();
        deleteByValue(map, num);
    }

    @Override
    public void deleteByValue(Map<String, Entity> map, int value) {
        map.entrySet().removeIf(entry -> entry.getValue().getValue() == value);
    }

    @Override
    public long calculateSum(Map<String, Entity> map) {
        return map.entrySet().stream()
                .mapToInt(entry -> entry.getValue().getValue())
                .sum();
    }

    @Override
    public Entity getThird(Map<String, Entity> map) {
        return null;
    }

    @Override
    public List<Entity> getTwoFromSecond(Map<String, Entity> map) {
        return null;
    }

    @Override
    public List<Entity> getAllByTemplate(Map<String, Entity> map) {
        return null;
    }

    @Override
    public boolean findSymbolInAllItems(Map<String, Entity> map, Character character) {
        return false;
    }

    @Override
    public Map<String, Entity> sorted(Map<String, Entity> map) {
        return null;
    }
}