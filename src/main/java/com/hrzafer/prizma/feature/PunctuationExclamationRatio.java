package com.hrzafer.prizma.feature;

import com.hrzafer.prizma.data.Document;
import com.hrzafer.prizma.preprocessing.Analyzer;

import java.util.Map;

/**
 *
 * @author hrzafer
 */
public class PunctuationExclamationRatio extends PunctuationRatio {

    public PunctuationExclamationRatio(String type, String name, int weight, String description, Map<String, String> parameters, Analyzer analyzer) {
        super(type, name, weight, description, parameters, analyzer);
        punctuation = EXCLAMATION;
    }



}
