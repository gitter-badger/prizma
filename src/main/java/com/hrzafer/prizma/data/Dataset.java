package com.hrzafer.prizma.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of categories.
 */
public class Dataset {

    private final List<Category> categories;
    private final List<String> fieldNames;

    public Dataset(List<Category> categories) {
        this.categories = categories;
        this.fieldNames = categories.get(0).getAllInstances().get(0).getFieldNames();
    }

    public List<String> getFieldNames() {
        return fieldNames;
    }

    public List<Document> getAllInstances() {
        return getPercentageSplittedInstances(100);
    }

    /**
     * Her sınıftan belirtilen yüzdede eğitim ve test numunesi alır.
     * Böylece verinin ilk bölümü farklı sınıflardan eşit yüzdede eğitim numuneleri bulunur.
     * Kalan kısımda ise yine her sınıftan eşit yüzdelerde test numuneleri bulunur.
     * @param trainPercentage eğitim verisinin yüzdesi
     * @return
     */
    public List<Document> getPercentageSplittedInstances(double trainPercentage) {

        List<Document> documents = new ArrayList<>();
        for (Category category : categories) {
            category.setTrainPercentage(trainPercentage);
            documents.addAll(category.getTrainInstances());
        }

        for (Category category : categories) {
            documents.addAll(category.getTestInstances());
        }
        return documents;
    }

    /**
     * Yalnızca belirtilen sınıfa ait numuneleri döndürür.
     * @param categoryName
     * @return
     */

    public List<Document> getInstancesOf(String categoryName) {
        return  getInstancesOf(categoryName, 100.0);
    }

    public List<Document> getInstancesOf(String categoryName, double percentage) {
        List<Document> samples = new ArrayList();
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                category.setTrainPercentage(percentage);
                samples.addAll(category.getTrainInstances());
                return samples;
            }
        }
        return null;
    }

    public List<String> getKlassNames() {
        List<String> names = new ArrayList<>();
        for (Category category : categories) {
            String name = category.getName();
            names.add(name);
        }
        return names;
    }

    /**
     * Shuffles the instances to make the instances in training and test sets be different
     */
    public void shuffle() {
        for (Category category : categories) {
            category.shuffle();
        }
    }

    public int getInstanceCount() {
        int count = 0;
        for (Category category : categories) {
            count += category.getInstanceCount();
        }
        return count;
    }

    public int getTrainInstanceCount() {
        int count = 0;
        for (Category category : categories) {
            count += category.getTrainInstanceCount();
        }
        return count;
    }
}
