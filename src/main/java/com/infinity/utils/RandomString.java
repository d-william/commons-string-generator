package com.infinity.utils;

import java.security.SecureRandom;
import java.util.Objects;

public class RandomString {

    public static final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_CASE_LETTERS = UPPER_CASE_LETTERS.toLowerCase();
    public static final String DIGITS = "0123456789";
    public static final String SPECIAL_CHARACTERS = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";

    private final SecureRandom random;
    private final char[] symbols;
    private final char[] buffer;

    /**
     * Constructs a secure random String generator.
     *
     * @param length  The length of generated strings.
     * @param random  The {@code SecureRandom} used for generate strings.
     * @param symbols The characters that can appear in generated strings.
     * @throws IllegalArgumentException if {@code length} is lower or equals to 1.
     * @throws IllegalArgumentException if the length of {@code symbols} is lower or equals to 2.
     * @throws NullPointerException     if {@code random} is {@code null}.
     */
    public RandomString(int length, SecureRandom random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buffer = new char[length];
    }

    /**
     * Constructs a secure random String generator that generate {@code String} that contain
     * upper case letters, lower case letters and digits.
     *
     * @param length The length of generated strings.
     * @param random The {@code SecureRandom} used for generate strings.
     * @throws IllegalArgumentException if {@code length} is lower or equals to 1.
     * @throws NullPointerException     if {@code random} is {@code null}.
     * @see #UPPER_CASE_LETTERS
     * @see #LOWER_CASE_LETTERS
     * @see #DIGITS
     */
    public RandomString(int length, SecureRandom random) {
        this(length, random, UPPER_CASE_LETTERS + LOWER_CASE_LETTERS + DIGITS);
    }

    /**
     * Constructs a secure random String generator with default {@code SecureRandom} implementation.
     *
     * @param length  The length of generated strings.
     * @param symbols The characters that can appear in generated strings.
     * @throws IllegalArgumentException if {@code length} is lower or equals to 1.
     * @throws IllegalArgumentException if the length of {@code symbols} is lower or equals to 2.
     * @see SecureRandom#SecureRandom()
     */
    public RandomString(int length, String symbols) {
        this(length, new SecureRandom(), symbols);
    }

    /**
     * Constructs a secure random String generator with default {@code SecureRandom} implementation
     * and that generate {@code String} that contain upper case letters, lower case letters and
     * digits.
     *
     * @param length The length of generated strings.
     * @throws IllegalArgumentException if {@code length} is lower or equals to 1.
     * @see #UPPER_CASE_LETTERS
     * @see #LOWER_CASE_LETTERS
     * @see #DIGITS
     * @see SecureRandom#SecureRandom()
     */
    public RandomString(int length) {
        this(length, new SecureRandom());
    }

    /**
     * Constructs a secure random String generator that generate {@code String} of length 8.
     *
     * @param random  The {@code SecureRandom} used for generate strings.
     * @param symbols The characters that can appear in generated strings.
     * @throws IllegalArgumentException if the length of {@code symbols} is lower or equals to 2.
     * @throws NullPointerException     if {@code random} is {@code null}.
     */
    public RandomString(SecureRandom random, String symbols) {
        this(8, new SecureRandom(), symbols);
    }

    /**
     * Constructs a secure random String generator that generate {@code String} of length 8 and
     * that contain upper case letters, lower case letters and digits.
     *
     * @param random The SecureRandom used for generate strings.
     * @throws NullPointerException if {@code random} is {@code null}.
     * @see #UPPER_CASE_LETTERS
     * @see #LOWER_CASE_LETTERS
     * @see #DIGITS
     */
    public RandomString(SecureRandom random) {
        this(8, random);
    }

    /**
     * Constructs a secure random String generator with default {@code SecureRandom} implementation
     * and that generate String of length 8.
     *
     * @param symbols The characters that can appear in generated strings.
     * @throws IllegalArgumentException if the length of {@code symbols} is lower or equals to 2.
     * @see SecureRandom#SecureRandom()
     */
    public RandomString(String symbols) {
        this(8, symbols);
    }

    /**
     * Constructs a secure random String generator :
     * <ul>
     * <li>with default {@code SecureRandom} implementation.</li>
     * <li>that generate {@code String} of length 8.</li>
     * <li>that generate {@code String} that contain upper case letters, lower case letters and digits.</li>
     * </ul>
     *
     * @see #UPPER_CASE_LETTERS
     * @see #LOWER_CASE_LETTERS
     * @see #DIGITS
     * @see SecureRandom#SecureRandom()
     */
    public RandomString() {
        this(8);
    }

    /**
     * Generate a new random {@code String}.
     *
     * @return the newly generated {@code String}.
     */
    public String nextString() {
        for (int idx = 0; idx < buffer.length; ++idx)
            buffer[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buffer);
    }

}