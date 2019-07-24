package com.event.parser;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.MappingStrategy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.opencsv.CSVParser.*;
import static java.util.Collections.emptyList;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class AbstractCsvParser<T> {

    private final MappingStrategy<T> mappingStrategy;

    protected AbstractCsvParser(MappingStrategy<T> mappingStrategy) {
        this.mappingStrategy = mappingStrategy;
    }

    public List<T> parse(InputStream stream) {
        try (CSVReader csvReader = buildCsvReader(stream)) {
            return new CsvToBean<T>().parse(mappingStrategy, csvReader);
        } catch (IOException e) {
            System.err.println("Failed to parse CSV.");
        }
        return emptyList();
    }

    protected char getSeparator() {
        return ';';
    }

    protected int getIgnoredLines() {
        return 0;
    }

    protected Character getCommentStartSymbol() {
        return null;
    }

    private CSVReader buildCsvReader(InputStream stream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String line = reader.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                if (!shouldSkipLine(line)) {
                    sb.append(line).append(System.lineSeparator());
                }
                line = reader.readLine();
            }
            CharArrayReader charArrayReader = new CharArrayReader(sb.toString().toCharArray());
            return new TrimmingCsvReader(charArrayReader, getSeparator(), NULL_CHARACTER, getIgnoredLines());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean shouldSkipLine(String line) {
        if (isBlank(line)) {
            return true;
        }

        Character commentStartSymbol = getCommentStartSymbol();

        if (commentStartSymbol == null) {
            return false;
        }

        String regex = "^\\s*" + commentStartSymbol + ".+";
        return line.matches(regex);
    }

    private static class TrimmingCsvReader extends CSVReader {

        private TrimmingCsvReader(Reader reader, char separator, char quoteChar, int line) {
            super(reader, separator, quoteChar, DEFAULT_ESCAPE_CHARACTER, line, DEFAULT_STRICT_QUOTES);
        }

        @Override
        public String[] readNext() throws IOException {
            String[] result = super.readNext();
            if (result == null) {
                return null;
            }
            for (int i = 0; i < result.length; i++) {
                result[i] = isBlank(result[i]) ? null : result[i].trim();
            }
            return result;
        }
    }
}