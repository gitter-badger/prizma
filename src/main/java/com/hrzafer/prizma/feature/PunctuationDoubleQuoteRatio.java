package com.hrzafer.prizma.feature;

import com.hrzafer.prizma.data.Document;
import com.hrzafer.prizma.preprocessing.Analyzer;

import java.util.Map;

/**
 *
 * @author hrzafer
 */
public class PunctuationDoubleQuoteRatio extends PunctuationRatio {

    public PunctuationDoubleQuoteRatio(String type, String name, int weight, String description, Map<String, String> parameters, Analyzer analyzer) {
        super(type, name, weight, description, parameters, analyzer);
    }

    @Override
    public String extract(Document document) {
        String data = getFieldData(document);
        return extractRatioAsFormattedString(data, DOUBLE_QUOTE);
    }
}
