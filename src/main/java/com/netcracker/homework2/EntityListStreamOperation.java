package com.netcracker.homework2;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EntityListStreamOperation implements ListOperation<Entity> {

    @Override
    public void deleteByMaxField(List<Entity> list) {
        int num = list.stream()
                .mapToInt(Entity::getValue)
                .max()
                .getAsInt();
        list.removeIf(entity -> entity.getValue() == num);
    }

    @Override
    public void deleteByMinField(List<Entity> list) {
        int num = list.stream()
                .mapToInt(Entity::getValue)
                .min()
                .getAsInt();
        list.removeIf(entity -> entity.getValue() == num);
    }

    @Override
    public void deleteByValue(List<Entity> list, int value) {
        list.removeIf(entity -> entity.getValue() > value);
    }

    @Override
    public long calculateSum(List<Entity> list) {
        return list.stream()
                .mapToInt(Entity::getValue)
                .sum();
    }

    @Override
    public Entity getThird(List<Entity> list) {
        return list.stream()
                .skip(2)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Entity> getTwoFromSecond(List<Entity> list) {
        return list.stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());
    }

    @Override
    public List<Entity> getAllByTemplate(List<Entity> list) {
        return list.stream()
                .filter(entity -> entity.getName().length() <= 5)
                .collect(Collectors.toList());
    }

    @Override
    public boolean findSymbolInAllItems(List<Entity> list, Character character) {
        return list.stream().allMatch(entity -> entity.getName().contains(character.toString()));
    }

    @Override
    public void addSymbolToName(List<Entity> list) {
        list.forEach(entity -> entity.setName(entity.getName() + "_1"));
    }

    @Override
    public void sorted(List<Entity> list) {
        List<Entity> result = list.stream()
                .sorted(Comparator.comparing(Entity::getName))
                .sorted(Comparator.comparing(Entity::getValue))
                .collect(Collectors.toList());
        list.clear();
        list.addAll(result);
    }
}
