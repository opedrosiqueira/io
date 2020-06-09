package io;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Stream;

/**
 * Wrapper class that encapsulates as static methods the public methods of the
 * Java SE System.out and Scanner objects.
 *
 * <p>
 * This class has a reference to a static final Scanner object that reads from
 * standard input (System.in) and a referente to standard object System.out.
 *
 * <p>
 * Each public static method in this class represents a public method of Scanner
 * or System.out.
 *
 * <p>
 * The purpose of this class is to make calls to Scanner and System.out methods
 * simpler and less verbose to read and write from standard input and output.
 *
 * @author pedro
 */
public final class io {

    private static final Scanner SCN = new Scanner(System.in);

    private io() {
    }

    /**
     * Flushes the stream. This is done by writing any buffered output bytes to
     * the underlying output stream and then flushing that stream.
     *
     * @see java.io.OutputStream#flush()
     */
    public static void flush() {
        System.out.flush();
    }

    /**
     * Flushes the stream and checks its error state. The internal error state
     * is set to {@code true} when the underlying output stream throws an
     * {@code IOException} other than {@code InterruptedIOException}, and when
     * the {@code setError} method is invoked. If an operation on the underlying
     * output stream throws an {@code InterruptedIOException}, then the
     * {@code PrintStream} converts the exception back into an interrupt by
     * doing:
     * <pre>{@code
     *     Thread.currentThread().interrupt();
     * }</pre> or the equivalent.
     *
     * @return {@code true} if and only if this stream has encountered an
     * {@code IOException} other than {@code InterruptedIOException}, or the
     * {@code setError} method has been invoked
     */
    public static boolean checkError() {
        return System.out.checkError();
    }

    /*
     * Exception-catching, synchronized output operations,
     * which also implement the write() methods of OutputStream
     */
    /**
     * Writes the specified byte to this stream. If the byte is a newline and
     * automatic flushing is enabled then the {@code flush} method will be
     * invoked.
     *
     * <p>
     * Note that the byte is written as given; to write a character that will be
     * translated according to the platform's default character encoding, use
     * the {@code print(char)} or {@code println(char)} methods.
     *
     * @param b The byte to be written
     * @see #print(char)
     * @see #println(char)
     */
    public static void write(int b) {
        System.out.write(b);
    }

    /**
     * Writes {@code len} bytes from the specified byte array starting at offset
     * {@code off} to this stream. If automatic flushing is enabled then the
     * {@code flush} method will be invoked.
     *
     * <p>
     * Note that the bytes will be written as given; to write characters that
     * will be translated according to the platform's default character
     * encoding, use the {@code print(char)} or {@code println(char)} methods.
     *
     * @param buf A byte array
     * @param off Offset from which to start taking bytes
     * @param len Number of bytes to write
     */
    public static void write(byte buf[], int off, int len) {
        System.out.write(buf, off, len);
    }

    /* Methods that do not terminate lines */
    /**
     * Prints a boolean value. The string produced by {@link
     * java.lang.String#valueOf(boolean)} is translated into bytes according to
     * the platform's default character encoding, and these bytes are written in
     * exactly the manner of the {@link #write(int)} method.
     *
     * @param b The {@code boolean} to be printed
     */
    public static void print(boolean b) {
        System.out.print(b);
    }

    /**
     * Prints a character. The character is translated into one or more bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the {@link #write(int)} method.
     *
     * @param c The {@code char} to be printed
     */
    public static void print(char c) {
        System.out.print(c);
    }

    /**
     * Prints an integer. The string produced by {@link
     * java.lang.String#valueOf(int)} is translated into bytes according to the
     * platform's default character encoding, and these bytes are written in
     * exactly the manner of the {@link #write(int)} method.
     *
     * @param i The {@code int} to be printed
     * @see java.lang.Integer#toString(int)
     */
    public static void print(int i) {
        System.out.print(i);
    }

    /**
     * Prints a long integer. The string produced by {@link
     * java.lang.String#valueOf(long)} is translated into bytes according to the
     * platform's default character encoding, and these bytes are written in
     * exactly the manner of the {@link #write(int)} method.
     *
     * @param l The {@code long} to be printed
     * @see java.lang.Long#toString(long)
     */
    public static void print(long l) {
        System.out.print(l);
    }

    /**
     * Prints a floating-point number. The string produced by {@link
     * java.lang.String#valueOf(float)} is translated into bytes according to
     * the platform's default character encoding, and these bytes are written in
     * exactly the manner of the {@link #write(int)} method.
     *
     * @param f The {@code float} to be printed
     * @see java.lang.Float#toString(float)
     */
    public static void print(float f) {
        System.out.print(f);
    }

    /**
     * Prints a double-precision floating-point number. The string produced by
     * {@link java.lang.String#valueOf(double)} is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the {@link
     * #write(int)} method.
     *
     * @param d The {@code double} to be printed
     * @see java.lang.Double#toString(double)
     */
    public static void print(double d) {
        System.out.print(d);
    }

    /**
     * Prints an array of characters. The characters are converted into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the {@link #write(int)} method.
     *
     * @param s The array of chars to be printed
     *
     * @throws NullPointerException If {@code s} is {@code null}
     */
    public static void print(char s[]) {
        System.out.print(s);
    }

    /**
     * Prints a string. If the argument is {@code null} then the string
     * {@code "null"} is printed. Otherwise, the string's characters are
     * converted into bytes according to the platform's default character
     * encoding, and these bytes are written in exactly the manner of the
     * {@link #write(int)} method.
     *
     * @param s The {@code String} to be printed
     */
    public static void print(String s) {
        System.out.print(s);
    }

    /**
     * Prints an object. The string produced by the {@link
     * java.lang.String#valueOf(Object)} method is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the {@link #write(int)} method.
     *
     * @param obj The {@code Object} to be printed
     * @see java.lang.Object#toString()
     */
    public static void print(Object obj) {
        System.out.print(obj);
    }


    /* Methods that do terminate lines */
    /**
     * Terminates the current line by writing the line separator string. The
     * line separator string is defined by the system property
     * {@code line.separator}, and is not necessarily a single newline character
     * ({@code '\n'}).
     */
    public static void println() {
        System.out.println();
    }

    /**
     * Prints a boolean and then terminate the line. This method behaves as
     * though it invokes {@link #print(boolean)} and then {@link #println()}.
     *
     * @param x The {@code boolean} to be printed
     */
    public static void println(boolean x) {
        System.out.println(x);
    }

    /**
     * Prints a character and then terminate the line. This method behaves as
     * though it invokes {@link #print(char)} and then {@link #println()}.
     *
     * @param x The {@code char} to be printed.
     */
    public static void println(char x) {
        System.out.println(x);
    }

    /**
     * Prints an integer and then terminate the line. This method behaves as
     * though it invokes {@link #print(int)} and then {@link #println()}.
     *
     * @param x The {@code int} to be printed.
     */
    public static void println(int x) {
        System.out.println(x);
    }

    /**
     * Prints a long and then terminate the line. This method behaves as though
     * it invokes {@link #print(long)} and then {@link #println()}.
     *
     * @param x a The {@code long} to be printed.
     */
    public static void println(long x) {
        System.out.println(x);
    }

    /**
     * Prints a float and then terminate the line. This method behaves as though
     * it invokes {@link #print(float)} and then {@link #println()}.
     *
     * @param x The {@code float} to be printed.
     */
    public static void println(float x) {
        System.out.println(x);
    }

    /**
     * Prints a double and then terminate the line. This method behaves as
     * though it invokes {@link #print(double)} and then {@link #println()}.
     *
     * @param x The {@code double} to be printed.
     */
    public static void println(double x) {
        System.out.println(x);
    }

    /**
     * Prints an array of characters and then terminate the line. This method
     * behaves as though it invokes {@link #print(char[])} and then
     * {@link #println()}.
     *
     * @param x an array of chars to print.
     */
    public static void println(char x[]) {
        System.out.println(x);
    }

    /**
     * Prints a String and then terminate the line. This method behaves as
     * though it invokes {@link #print(String)} and then {@link #println()}.
     *
     * @param x The {@code String} to be printed.
     */
    public static void println(String x) {
        System.out.println(x);
    }

    /**
     * Prints an Object and then terminate the line. This method calls at first
     * String.valueOf(x) to get the printed object's string value, then behaves
     * as though it invokes {@link #print(String)} and then {@link #println()}.
     *
     * @param x The {@code Object} to be printed.
     */
    public static void println(Object x) {
        System.out.println(x);
    }

    /**
     * A convenience method to write a formatted string to this output stream
     * using the specified format string and arguments.
     *
     * <p>
     * An invocation of this method of the form {@code out.printf(format, args)}
     * behaves in exactly the same way as the invocation
     *
     * <pre>{@code
     *     out.format(format, args)
     * }</pre>
     *
     * @param format A format string as described in <a
     *         href="../util/Formatter.html#syntax">Format string syntax</a>
     *
     * @param args Arguments referenced by the format specifiers in the format
     * string. If there are more arguments than format specifiers, the extra
     * arguments are ignored. The number of arguments is variable and may be
     * zero. The maximum number of arguments is limited by the maximum dimension
     * of a Java array as defined by
     * <cite>The Java&trade; Virtual Machine Specification</cite>. The behaviour
     * on a {@code null} argument depends on the <a
     *         href="../util/Formatter.html#syntax">conversion</a>.
     *
     * @throws java.util.IllegalFormatException If a format string contains an
     * illegal syntax, a format specifier that is incompatible with the given
     * arguments, insufficient arguments given the format string, or other
     * illegal conditions. For specification of all possible formatting errors,
     * see the <a
     *          href="../util/Formatter.html#detail">Details</a> section of the formatter
     * class specification.
     *
     * @throws NullPointerException If the {@code format} is {@code null}
     *
     * @return This output stream
     *
     * @since 1.5
     */
    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }

    /**
     * A convenience method to write a formatted string to this output stream
     * using the specified format string and arguments.
     *
     * <p>
     * An invocation of this method of the form
     * {@code out.printf(l, format, args)} behaves in exactly the same way as
     * the invocation
     *
     * <pre>{@code
     *     out.format(l, format, args)
     * }</pre>
     *
     * @param l The {@linkplain java.util.Locale locale} to apply during
     * formatting. If {@code l} is {@code null} then no localization is applied.
     *
     * @param format A format string as described in <a
     *         href="../util/Formatter.html#syntax">Format string syntax</a>
     *
     * @param args Arguments referenced by the format specifiers in the format
     * string. If there are more arguments than format specifiers, the extra
     * arguments are ignored. The number of arguments is variable and may be
     * zero. The maximum number of arguments is limited by the maximum dimension
     * of a Java array as defined by
     * <cite>The Java&trade; Virtual Machine Specification</cite>. The behaviour
     * on a {@code null} argument depends on the <a
     *         href="../util/Formatter.html#syntax">conversion</a>.
     *
     * @throws java.util.IllegalFormatException If a format string contains an
     * illegal syntax, a format specifier that is incompatible with the given
     * arguments, insufficient arguments given the format string, or other
     * illegal conditions. For specification of all possible formatting errors,
     * see the <a
     *          href="../util/Formatter.html#detail">Details</a> section of the formatter
     * class specification.
     *
     * @throws NullPointerException If the {@code format} is {@code null}
     *
     * @return This output stream
     *
     * @since 1.5
     */
    public static PrintStream printf(Locale l, String format, Object... args) {
        return System.out.printf(format, args);
    }

    /**
     * Writes a formatted string to this output stream using the specified
     * format string and arguments.
     *
     * <p>
     * The locale always used is the one returned by {@link
     * java.util.Locale#getDefault(Locale.Category)} with
     * {@link java.util.Locale.Category#FORMAT FORMAT} category specified,
     * regardless of any previous invocations of other formatting methods on
     * this object.
     *
     * @param format A format string as described in <a
     *         href="../util/Formatter.html#syntax">Format string syntax</a>
     *
     * @param args Arguments referenced by the format specifiers in the format
     * string. If there are more arguments than format specifiers, the extra
     * arguments are ignored. The number of arguments is variable and may be
     * zero. The maximum number of arguments is limited by the maximum dimension
     * of a Java array as defined by
     * <cite>The Java&trade; Virtual Machine Specification</cite>. The behaviour
     * on a {@code null} argument depends on the <a
     *         href="../util/Formatter.html#syntax">conversion</a>.
     *
     * @throws java.util.IllegalFormatException If a format string contains an
     * illegal syntax, a format specifier that is incompatible with the given
     * arguments, insufficient arguments given the format string, or other
     * illegal conditions. For specification of all possible formatting errors,
     * see the <a
     *          href="../util/Formatter.html#detail">Details</a> section of the formatter
     * class specification.
     *
     * @throws NullPointerException If the {@code format} is {@code null}
     *
     * @return This output stream
     *
     * @since 1.5
     */
    public static PrintStream format(String format, Object... args) {
        return System.out.format(format, args);
    }

    /**
     * Writes a formatted string to this output stream using the specified
     * format string and arguments.
     *
     * @param l The {@linkplain java.util.Locale locale} to apply during
     * formatting. If {@code l} is {@code null} then no localization is applied.
     *
     * @param format A format string as described in <a
     *         href="../util/Formatter.html#syntax">Format string syntax</a>
     *
     * @param args Arguments referenced by the format specifiers in the format
     * string. If there are more arguments than format specifiers, the extra
     * arguments are ignored. The number of arguments is variable and may be
     * zero. The maximum number of arguments is limited by the maximum dimension
     * of a Java array as defined by
     * <cite>The Java&trade; Virtual Machine Specification</cite>. The behaviour
     * on a {@code null} argument depends on the <a
     *         href="../util/Formatter.html#syntax">conversion</a>.
     *
     * @throws java.util.IllegalFormatException If a format string contains an
     * illegal syntax, a format specifier that is incompatible with the given
     * arguments, insufficient arguments given the format string, or other
     * illegal conditions. For specification of all possible formatting errors,
     * see the <a
     *          href="../util/Formatter.html#detail">Details</a> section of the formatter
     * class specification.
     *
     * @throws NullPointerException If the {@code format} is {@code null}
     *
     * @return This output stream
     *
     * @since 1.5
     */
    public static PrintStream format(Locale l, String format, Object... args) {
        return System.out.format(format, args);
    }

    /**
     * Appends the specified character sequence to this output stream.
     *
     * <p>
     * An invocation of this method of the form {@code out.append(csq)} behaves
     * in exactly the same way as the invocation
     *
     * <pre>{@code
     *     out.print(csq.toString())
     * }</pre>
     *
     * <p>
     * Depending on the specification of {@code toString} for the character
     * sequence {@code csq}, the entire sequence may not be appended. For
     * instance, invoking then {@code toString} method of a character buffer
     * will return a subsequence whose content depends upon the buffer's
     * position and limit.
     *
     * @param csq The character sequence to append. If {@code csq} is
     * {@code null}, then the four characters {@code "null"} are appended to
     * this output stream.
     *
     * @return This output stream
     *
     * @since 1.5
     */
    public static PrintStream append(CharSequence csq) {
        return System.out.append(csq);
    }

    /**
     * Appends a subsequence of the specified character sequence to this output
     * stream.
     *
     * <p>
     * An invocation of this method of the form
     * {@code out.append(csq, start, end)} when {@code csq} is not {@code null},
     * behaves in exactly the same way as the invocation
     *
     * <pre>{@code
     *     out.print(csq.subSequence(start, end).toString())
     * }</pre>
     *
     * @param csq The character sequence from which a subsequence will be
     * appended. If {@code csq} is {@code null}, then characters will be
     * appended as if {@code csq} contained the four characters {@code "null"}.
     *
     * @param start The index of the first character in the subsequence
     *
     * @param end The index of the character following the last character in the
     * subsequence
     *
     * @return This output stream
     *
     * @throws IndexOutOfBoundsException If {@code start} or {@code end} are
     * negative, {@code start} is greater than {@code end}, or {@code end} is
     * greater than {@code csq.length()}
     *
     * @since 1.5
     */
    public static PrintStream append(CharSequence csq, int start, int end) {
        return System.out.append(csq);
    }

    /**
     * Appends the specified character to this output stream.
     *
     * <p>
     * An invocation of this method of the form {@code out.append(c)} behaves in
     * exactly the same way as the invocation
     *
     * <pre>{@code
     *     out.print(c)
     * }</pre>
     *
     * @param c The 16-bit character to append
     *
     * @return This output stream
     *
     * @since 1.5
     */
    public static PrintStream append(char c) {
        return System.out.append(c);
    }

    /**
     * Closes this scanner and Closes the stream.
     *
     * <p>
     * Closing the stream is done by flushing the stream and then closing the
     * underlying output stream.
     *
     * <p>
     * If this scanner has not yet been closed then if its underlying
     * {@linkplain java.lang.Readable readable} also implements the {@link
     * java.io.Closeable} interface then the readable's {@code close} method
     * will be invoked. If this scanner is already closed then invoking this
     * method will have no effect.
     *
     * <p>
     * Attempting to perform search operations after a scanner has been closed
     * will result in an {@link IllegalStateException}.
     *
     * @see java.io.OutputStream#close()
     */
    public static void close() {
        System.out.close();
        SCN.close();
    }

    /**
     * Returns the {@code IOException} last thrown by this {@code Scanner}'s
     * underlying {@code Readable}. This method returns {@code null} if no such
     * exception exists.
     *
     * @return the last exception thrown by this scanner's readable
     */
    public static IOException ioException() {
        return SCN.ioException();
    }

    /**
     * Returns the {@code Pattern} this {@code Scanner} is currently using to
     * match delimiters.
     *
     * @return this scanner's delimiting pattern.
     */
    public static Pattern delimiter() {
        return SCN.delimiter();
    }

    /**
     * Sets this scanner's delimiting pattern to the specified pattern.
     *
     * @param pattern A delimiting pattern
     * @return this scanner
     */
    public static Scanner useDelimiter(Pattern pattern) {
        return SCN.useDelimiter(pattern);
    }

    /**
     * Sets this scanner's delimiting pattern to a pattern constructed from the
     * specified {@code String}.
     *
     * <p>
     * An invocation of this method of the form {@code useDelimiter(pattern)}
     * behaves in exactly the same way as the invocation
     * {@code useDelimiter(Pattern.compile(pattern))}.
     *
     * <p>
     * Invoking the {@link #reset} method will set the scanner's delimiter to
     * the <a href= "#default-delimiter">default</a>.
     *
     * @param pattern A string specifying a delimiting pattern
     * @return this scanner
     */
    public static Scanner useDelimiter(String pattern) {
        return SCN.useDelimiter(pattern);
    }

    /**
     * Returns this scanner's locale.
     *
     * <p>
     * A scanner's locale affects many elements of its default primitive
     * matching regular expressions; see
     * <a href= "#localized-numbers">localized numbers</a> above.
     *
     * @return this scanner's locale
     */
    public static Locale locale() {
        return SCN.locale();
    }

    /**
     * Sets this scanner's locale to the specified locale.
     *
     * <p>
     * A scanner's locale affects many elements of its default primitive
     * matching regular expressions; see
     * <a href= "#localized-numbers">localized numbers</a> above.
     *
     * <p>
     * Invoking the {@link #reset} method will set the scanner's locale to the
     * <a href= "#initial-locale">initial locale</a>.
     *
     * @param locale A string specifying the locale to use
     * @return this scanner
     */
    public static Scanner useLocale(Locale locale) {
        return SCN.useLocale(locale);
    }

    /**
     * Returns this scanner's default radix.
     *
     * <p>
     * A scanner's radix affects elements of its default number matching regular
     * expressions; see
     * <a href= "#localized-numbers">localized numbers</a> above.
     *
     * @return the default radix of this scanner
     */
    public static int radix() {
        return SCN.radix();
    }

    /**
     * Sets this scanner's default radix to the specified radix.
     *
     * <p>
     * A scanner's radix affects elements of its default number matching regular
     * expressions; see
     * <a href= "#localized-numbers">localized numbers</a> above.
     *
     * <p>
     * If the radix is less than {@link Character#MIN_RADIX Character.MIN_RADIX}
     * or greater than {@link Character#MAX_RADIX Character.MAX_RADIX}, then an
     * {@code IllegalArgumentException} is thrown.
     *
     * <p>
     * Invoking the {@link #reset} method will set the scanner's radix to
     * {@code 10}.
     *
     * @param radix The radix to use when scanning numbers
     * @return this scanner
     * @throws IllegalArgumentException if radix is out of range
     */
    public static Scanner useRadix(int radix) {
        return SCN.useRadix(radix);
    }

    /**
     * Returns the match result of the last scanning operation performed by this
     * scanner. This method throws {@code IllegalStateException} if no match has
     * been performed, or if the last match was not successful.
     *
     * <p>
     * The various {@code next} methods of {@code Scanner} make a match result
     * available if they complete without throwing an exception. For instance,
     * after an invocation of the {@link #nextInt} method that returned an int,
     * this method returns a {@code MatchResult} for the search of the
     * <a href="#Integer-regex"><i>Integer</i></a> regular expression defined
     * above. Similarly the {@link #findInLine findInLine()},
     * {@link #findWithinHorizon findWithinHorizon()}, and {@link #skip skip()}
     * methods will make a match available if they succeed.
     *
     * @return a match result for the last match operation
     * @throws IllegalStateException If no match result is available
     */
    public static MatchResult match() {
        return SCN.match();
    }

    /**
     * <p>
     * Returns the string representation of this {@code Scanner}. The string
     * representation of a {@code Scanner} contains information that may be
     * useful for debugging. The exact format is unspecified.
     *
     * @return The string representation of this scanner
     */
    public static String tostring() {
        return SCN.toString();
    }

    /**
     * Returns true if this scanner has another token in its input. This method
     * may block while waiting for input to scan. The scanner does not advance
     * past any input.
     *
     * @return true if and only if this scanner has another token
     * @throws IllegalStateException if this scanner is closed
     * @see java.util.Iterator
     */
    public static boolean hasNext() {
        return SCN.hasNext();
    }

    /**
     * Finds and returns the next complete token from this scanner. A complete
     * token is preceded and followed by input that matches the delimiter
     * pattern. This method may block while waiting for input to scan, even if a
     * previous invocation of {@link #hasNext} returned {@code true}.
     *
     * @return the next token
     * @throws NoSuchElementException if no more tokens are available
     * @throws IllegalStateException if this scanner is closed
     * @see java.util.Iterator
     */
    public static String next() {
        return SCN.next();
    }

    /**
     * Returns true if the next token matches the pattern constructed from the
     * specified string. The scanner does not advance past any input.
     *
     * <p>
     * An invocation of this method of the form {@code hasNext(pattern)} behaves
     * in exactly the same way as the invocation
     * {@code hasNext(Pattern.compile(pattern))}.
     *
     * @param pattern a string specifying the pattern to scan
     * @return true if and only if this scanner has another token matching the
     * specified pattern
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean hasNext(String pattern) {
        return SCN.hasNext(pattern);
    }

    /**
     * Returns the next token if it matches the pattern constructed from the
     * specified string. If the match is successful, the scanner advances past
     * the input that matched the pattern.
     *
     * <p>
     * An invocation of this method of the form {@code next(pattern)} behaves in
     * exactly the same way as the invocation
     * {@code next(Pattern.compile(pattern))}.
     *
     * @param pattern a string specifying the pattern to scan
     * @return the next token
     * @throws NoSuchElementException if no such tokens are available
     * @throws IllegalStateException if this scanner is closed
     */
    public static String next(String pattern) {
        return SCN.next(pattern);
    }

    /**
     * Returns true if the next complete token matches the specified pattern. A
     * complete token is prefixed and postfixed by input that matches the
     * delimiter pattern. This method may block while waiting for input. The
     * scanner does not advance past any input.
     *
     * @param pattern the pattern to scan for
     * @return true if and only if this scanner has another token matching the
     * specified pattern
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean hasNext(Pattern pattern) {
        return SCN.hasNext(pattern);
    }

    /**
     * Returns the next token if it matches the specified pattern. This method
     * may block while waiting for input to scan, even if a previous invocation
     * of {@link #hasNext(Pattern)} returned {@code true}. If the match is
     * successful, the scanner advances past the input that matched the pattern.
     *
     * @param pattern the pattern to scan for
     * @return the next token
     * @throws NoSuchElementException if no more tokens are available
     * @throws IllegalStateException if this scanner is closed
     */
    public static String next(Pattern pattern) {
        return SCN.next(pattern);
    }

    /**
     * Returns true if there is another line in the input of this scanner. This
     * method may block while waiting for input. The scanner does not advance
     * past any input.
     *
     * @return true if and only if this scanner has another line of input
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean hasNextLine() {
        return SCN.hasNextLine();
    }

    /**
     * Advances this scanner past the current line and returns the input that
     * was skipped.
     *
     * This method returns the rest of the current line, excluding any line
     * separator at the end. The position is set to the beginning of the next
     * line.
     *
     * <p>
     * Since this method continues to search through the input looking for a
     * line separator, it may buffer all of the input searching for the line to
     * skip if no line separators are present.
     *
     * @return the line that was skipped
     * @throws NoSuchElementException if no line was found
     * @throws IllegalStateException if this scanner is closed
     */
    public static String nextLine() {
        return SCN.nextLine();
    }

    // Public methods that ignore delimiters
    /**
     * Attempts to find the next occurrence of a pattern constructed from the
     * specified string, ignoring delimiters.
     *
     * <p>
     * An invocation of this method of the form {@code findInLine(pattern)}
     * behaves in exactly the same way as the invocation
     * {@code findInLine(Pattern.compile(pattern))}.
     *
     * @param pattern a string specifying the pattern to search for
     * @return the text that matched the specified pattern
     * @throws IllegalStateException if this scanner is closed
     */
    public static String findInLine(String pattern) {
        return SCN.findInLine(pattern);
    }

    /**
     * Attempts to find the next occurrence of the specified pattern ignoring
     * delimiters. If the pattern is found before the next line separator, the
     * scanner advances past the input that matched and returns the string that
     * matched the pattern. If no such pattern is detected in the input up to
     * the next line separator, then {@code null} is returned and the scanner's
     * position is unchanged. This method may block waiting for input that
     * matches the pattern.
     *
     * <p>
     * Since this method continues to search through the input looking for the
     * specified pattern, it may buffer all of the input searching for the
     * desired token if no line separators are present.
     *
     * @param pattern the pattern to scan for
     * @return the text that matched the specified pattern
     * @throws IllegalStateException if this scanner is closed
     */
    public static String findInLine(Pattern pattern) {
        return SCN.findInLine(pattern);
    }

    /**
     * Attempts to find the next occurrence of a pattern constructed from the
     * specified string, ignoring delimiters.
     *
     * <p>
     * An invocation of this method of the form
     * {@code findWithinHorizon(pattern)} behaves in exactly the same way as the
     * invocation {@code findWithinHorizon(Pattern.compile(pattern), horizon)}.
     *
     * @param pattern a string specifying the pattern to search for
     * @param horizon the search horizon
     * @return the text that matched the specified pattern
     * @throws IllegalStateException if this scanner is closed
     * @throws IllegalArgumentException if horizon is negative
     */
    public static String findWithinHorizon(String pattern, int horizon) {
        return SCN.findWithinHorizon(pattern, horizon);
    }

    /**
     * Attempts to find the next occurrence of the specified pattern.
     *
     * <p>
     * This method searches through the input up to the specified search
     * horizon, ignoring delimiters. If the pattern is found the scanner
     * advances past the input that matched and returns the string that matched
     * the pattern. If no such pattern is detected then the null is returned and
     * the scanner's position remains unchanged. This method may block waiting
     * for input that matches the pattern.
     *
     * <p>
     * A scanner will never search more than {@code horizon} code points beyond
     * its current position. Note that a match may be clipped by the horizon;
     * that is, an arbitrary match result may have been different if the horizon
     * had been larger. The scanner treats the horizon as a transparent,
     * non-anchoring bound (see {@link
     * Matcher#useTransparentBounds} and {@link Matcher#useAnchoringBounds}).
     *
     * <p>
     * If horizon is {@code 0}, then the horizon is ignored and this method
     * continues to search through the input looking for the specified pattern
     * without bound. In this case it may buffer all of the input searching for
     * the pattern.
     *
     * <p>
     * If horizon is negative, then an IllegalArgumentException is thrown.
     *
     * @param pattern the pattern to scan for
     * @param horizon the search horizon
     * @return the text that matched the specified pattern
     * @throws IllegalStateException if this scanner is closed
     * @throws IllegalArgumentException if horizon is negative
     */
    public static String findWithinHorizon(Pattern pattern, int horizon) {
        return SCN.findWithinHorizon(pattern, horizon);
    }

    /**
     * Skips input that matches the specified pattern, ignoring delimiters. This
     * method will skip input if an anchored match of the specified pattern
     * succeeds.
     *
     * <p>
     * If a match to the specified pattern is not found at the current position,
     * then no input is skipped and a {@code NoSuchElementException} is thrown.
     *
     * <p>
     * Since this method seeks to match the specified pattern starting at the
     * scanner's current position, patterns that can match a lot of input (".*",
     * for example) may cause the scanner to buffer a large amount of input.
     *
     * <p>
     * Note that it is possible to skip something without risking a
     * {@code NoSuchElementException} by using a pattern that can match nothing,
     * e.g., {@code sc.skip("[ \t]*")}.
     *
     * @param pattern a string specifying the pattern to skip over
     * @return this scanner
     * @throws NoSuchElementException if the specified pattern is not found
     * @throws IllegalStateException if this scanner is closed
     */
    public static Scanner skip(Pattern pattern) {
        return SCN.skip(pattern);
    }

    /**
     * Skips input that matches a pattern constructed from the specified string.
     *
     * <p>
     * An invocation of this method of the form {@code skip(pattern)} behaves in
     * exactly the same way as the invocation
     * {@code skip(Pattern.compile(pattern))}.
     *
     * @param pattern a string specifying the pattern to skip over
     * @return this scanner
     * @throws IllegalStateException if this scanner is closed
     */
    public static Scanner skip(String pattern) {
        return SCN.skip(pattern);
    }

    // Convenience methods for scanning primitives
    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as a boolean value using a case insensitive pattern created from the
     * string "true|false". The scanner does not advance past the input that
     * matched.
     *
     * @return true if and only if this scanner's next token is a valid boolean
     * value
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean hasNextBoolean() {
        return SCN.hasNextBoolean();
    }

    /**
     * Scans the next token of the input into a boolean value and returns that
     * value. This method will throw {@code InputMismatchException} if the next
     * token cannot be translated into a valid boolean value. If the match is
     * successful, the scanner advances past the input that matched.
     *
     * @return the boolean scanned from the input
     * @throws InputMismatchException if the next token is not a valid boolean
     * @throws NoSuchElementException if input is exhausted
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean nextBoolean() {
        return SCN.nextBoolean();
    }

    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as a byte value in the default radix using the {@link #nextByte} method.
     * The scanner does not advance past any input.
     *
     * @return true if and only if this scanner's next token is a valid byte
     * value
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean hasNextByte() {
        return SCN.hasNextByte();
    }

    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as a byte value in the specified radix using the {@link #nextByte}
     * method. The scanner does not advance past any input.
     *
     * <p>
     * If the radix is less than {@link Character#MIN_RADIX Character.MIN_RADIX}
     * or greater than {@link Character#MAX_RADIX Character.MAX_RADIX}, then an
     * {@code IllegalArgumentException} is thrown.
     *
     * @param radix the radix used to interpret the token as a byte value
     * @return true if and only if this scanner's next token is a valid byte
     * value
     * @throws IllegalStateException if this scanner is closed
     * @throws IllegalArgumentException if the radix is out of range
     */
    public static boolean hasNextByte(int radix) {
        return SCN.hasNextByte(radix);
    }

    /**
     * Scans the next token of the input as a {@code byte}.
     *
     * <p>
     * An invocation of this method of the form {@code nextByte()} behaves in
     * exactly the same way as the invocation {@code nextByte(radix)}, where
     * {@code radix} is the default radix of this scanner.
     *
     * @return the {@code byte} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Integer</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if input is exhausted
     * @throws IllegalStateException if this scanner is closed
     */
    public static byte nextByte() {
        return SCN.nextByte();
    }

    /**
     * Scans the next token of the input as a {@code byte}. This method will
     * throw {@code InputMismatchException} if the next token cannot be
     * translated into a valid byte value as described below. If the translation
     * is successful, the scanner advances past the input that matched.
     *
     * <p>
     * If the next token matches the <a
     * href="#Integer-regex"><i>Integer</i></a> regular expression defined above
     * then the token is converted into a {@code byte} value as if by removing
     * all locale specific prefixes, group separators, and locale specific
     * suffixes, then mapping non-ASCII digits into ASCII digits via
     * {@link Character#digit Character.digit}, prepending a negative sign (-)
     * if the locale specific negative prefixes and suffixes were present, and
     * passing the resulting string to
     * {@link Byte#parseByte(String, int) Byte.parseByte} with the specified
     * radix.
     *
     * <p>
     * If the radix is less than {@link Character#MIN_RADIX Character.MIN_RADIX}
     * or greater than {@link Character#MAX_RADIX Character.MAX_RADIX}, then an
     * {@code IllegalArgumentException} is thrown.
     *
     * @param radix the radix used to interpret the token as a byte value
     * @return the {@code byte} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Integer</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if input is exhausted
     * @throws IllegalStateException if this scanner is closed
     * @throws IllegalArgumentException if the radix is out of range
     */
    public static byte nextByte(int radix) {
        return SCN.nextByte(radix);
    }

    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as a short value in the default radix using the {@link #nextShort}
     * method. The scanner does not advance past any input.
     *
     * @return true if and only if this scanner's next token is a valid short
     * value in the default radix
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean hasNextShort() {
        return SCN.hasNextShort();
    }

    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as a short value in the specified radix using the {@link #nextShort}
     * method. The scanner does not advance past any input.
     *
     * <p>
     * If the radix is less than {@link Character#MIN_RADIX Character.MIN_RADIX}
     * or greater than {@link Character#MAX_RADIX Character.MAX_RADIX}, then an
     * {@code IllegalArgumentException} is thrown.
     *
     * @param radix the radix used to interpret the token as a short value
     * @return true if and only if this scanner's next token is a valid short
     * value in the specified radix
     * @throws IllegalStateException if this scanner is closed
     * @throws IllegalArgumentException if the radix is out of range
     */
    public static boolean hasNextShort(int radix) {
        return SCN.hasNextShort(radix);
    }

    /**
     * Scans the next token of the input as a {@code short}.
     *
     * <p>
     * An invocation of this method of the form {@code nextShort()} behaves in
     * exactly the same way as the invocation
     * {@link #nextShort(int) nextShort(radix)}, where {@code radix} is the
     * default radix of this scanner.
     *
     * @return the {@code short} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Integer</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if input is exhausted
     * @throws IllegalStateException if this scanner is closed
     */
    public static short nextShort() {
        return SCN.nextShort();
    }

    /**
     * Scans the next token of the input as a {@code short}. This method will
     * throw {@code InputMismatchException} if the next token cannot be
     * translated into a valid short value as described below. If the
     * translation is successful, the scanner advances past the input that
     * matched.
     *
     * <p>
     * If the next token matches the <a
     * href="#Integer-regex"><i>Integer</i></a> regular expression defined above
     * then the token is converted into a {@code short} value as if by removing
     * all locale specific prefixes, group separators, and locale specific
     * suffixes, then mapping non-ASCII digits into ASCII digits via
     * {@link Character#digit Character.digit}, prepending a negative sign (-)
     * if the locale specific negative prefixes and suffixes were present, and
     * passing the resulting string to
     * {@link Short#parseShort(String, int) Short.parseShort} with the specified
     * radix.
     *
     * <p>
     * If the radix is less than {@link Character#MIN_RADIX Character.MIN_RADIX}
     * or greater than {@link Character#MAX_RADIX Character.MAX_RADIX}, then an
     * {@code IllegalArgumentException} is thrown.
     *
     * @param radix the radix used to interpret the token as a short value
     * @return the {@code short} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Integer</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if input is exhausted
     * @throws IllegalStateException if this scanner is closed
     * @throws IllegalArgumentException if the radix is out of range
     */
    static public short nextShort(int radix) {
        return SCN.nextShort(radix);
    }

    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as an int value in the default radix using the {@link #nextInt} method.
     * The scanner does not advance past any input.
     *
     * @return true if and only if this scanner's next token is a valid int
     * value
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean hasNextInt() {
        return SCN.hasNextInt();
    }

    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as an int value in the specified radix using the {@link #nextInt} method.
     * The scanner does not advance past any input.
     *
     * <p>
     * If the radix is less than {@link Character#MIN_RADIX Character.MIN_RADIX}
     * or greater than {@link Character#MAX_RADIX Character.MAX_RADIX}, then an
     * {@code IllegalArgumentException} is thrown.
     *
     * @param radix the radix used to interpret the token as an int value
     * @return true if and only if this scanner's next token is a valid int
     * value
     * @throws IllegalStateException if this scanner is closed
     * @throws IllegalArgumentException if the radix is out of range
     */
    public static boolean hasNextInt(int radix) {
        return SCN.hasNextInt(radix);
    }

    /**
     * Scans the next token of the input as an {@code int}.
     *
     * <p>
     * An invocation of this method of the form {@code nextInt()} behaves in
     * exactly the same way as the invocation {@code nextInt(radix)}, where
     * {@code radix} is the default radix of this scanner.
     *
     * @return the {@code int} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Integer</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if input is exhausted
     * @throws IllegalStateException if this scanner is closed
     */
    public static int nextInt() {
        return SCN.nextInt();
    }

    /**
     * Scans the next token of the input as an {@code int}. This method will
     * throw {@code InputMismatchException} if the next token cannot be
     * translated into a valid int value as described below. If the translation
     * is successful, the scanner advances past the input that matched.
     *
     * <p>
     * If the next token matches the <a
     * href="#Integer-regex"><i>Integer</i></a> regular expression defined above
     * then the token is converted into an {@code int} value as if by removing
     * all locale specific prefixes, group separators, and locale specific
     * suffixes, then mapping non-ASCII digits into ASCII digits via
     * {@link Character#digit Character.digit}, prepending a negative sign (-)
     * if the locale specific negative prefixes and suffixes were present, and
     * passing the resulting string to
     * {@link Integer#parseInt(String, int) Integer.parseInt} with the specified
     * radix.
     *
     * <p>
     * If the radix is less than {@link Character#MIN_RADIX Character.MIN_RADIX}
     * or greater than {@link Character#MAX_RADIX Character.MAX_RADIX}, then an
     * {@code IllegalArgumentException} is thrown.
     *
     * @param radix the radix used to interpret the token as an int value
     * @return the {@code int} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Integer</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if input is exhausted
     * @throws IllegalStateException if this scanner is closed
     * @throws IllegalArgumentException if the radix is out of range
     */
    public static int nextInt(int radix) {
        return SCN.nextInt(radix);
    }

    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as a long value in the default radix using the {@link #nextLong} method.
     * The scanner does not advance past any input.
     *
     * @return true if and only if this scanner's next token is a valid long
     * value
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean hasNextLong() {
        return SCN.hasNextLong();
    }

    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as a long value in the specified radix using the {@link #nextLong}
     * method. The scanner does not advance past any input.
     *
     * <p>
     * If the radix is less than {@link Character#MIN_RADIX Character.MIN_RADIX}
     * or greater than {@link Character#MAX_RADIX Character.MAX_RADIX}, then an
     * {@code IllegalArgumentException} is thrown.
     *
     * @param radix the radix used to interpret the token as a long value
     * @return true if and only if this scanner's next token is a valid long
     * value
     * @throws IllegalStateException if this scanner is closed
     * @throws IllegalArgumentException if the radix is out of range
     */
    public static boolean hasNextLong(int radix) {
        return SCN.hasNextLong(radix);
    }

    /**
     * Scans the next token of the input as a {@code long}.
     *
     * <p>
     * An invocation of this method of the form {@code nextLong()} behaves in
     * exactly the same way as the invocation {@code nextLong(radix)}, where
     * {@code radix} is the default radix of this scanner.
     *
     * @return the {@code long} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Integer</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if input is exhausted
     * @throws IllegalStateException if this scanner is closed
     */
    public static long nextLong() {
        return SCN.nextLong();
    }

    /**
     * Scans the next token of the input as a {@code long}. This method will
     * throw {@code InputMismatchException} if the next token cannot be
     * translated into a valid long value as described below. If the translation
     * is successful, the scanner advances past the input that matched.
     *
     * <p>
     * If the next token matches the <a
     * href="#Integer-regex"><i>Integer</i></a> regular expression defined above
     * then the token is converted into a {@code long} value as if by removing
     * all locale specific prefixes, group separators, and locale specific
     * suffixes, then mapping non-ASCII digits into ASCII digits via
     * {@link Character#digit Character.digit}, prepending a negative sign (-)
     * if the locale specific negative prefixes and suffixes were present, and
     * passing the resulting string to
     * {@link Long#parseLong(String, int) Long.parseLong} with the specified
     * radix.
     *
     * <p>
     * If the radix is less than {@link Character#MIN_RADIX Character.MIN_RADIX}
     * or greater than {@link Character#MAX_RADIX Character.MAX_RADIX}, then an
     * {@code IllegalArgumentException} is thrown.
     *
     * @param radix the radix used to interpret the token as an int value
     * @return the {@code long} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Integer</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if input is exhausted
     * @throws IllegalStateException if this scanner is closed
     * @throws IllegalArgumentException if the radix is out of range
     */
    public static long nextLong(int radix) {
        return SCN.nextLong(radix);
    }

    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as a float value using the {@link #nextFloat} method. The scanner does
     * not advance past any input.
     *
     * @return true if and only if this scanner's next token is a valid float
     * value
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean hasNextFloat() {
        return SCN.hasNextFloat();
    }

    /**
     * Scans the next token of the input as a {@code float}. This method will
     * throw {@code InputMismatchException} if the next token cannot be
     * translated into a valid float value as described below. If the
     * translation is successful, the scanner advances past the input that
     * matched.
     *
     * <p>
     * If the next token matches the <a
     * href="#Float-regex"><i>Float</i></a> regular expression defined above
     * then the token is converted into a {@code float} value as if by removing
     * all locale specific prefixes, group separators, and locale specific
     * suffixes, then mapping non-ASCII digits into ASCII digits via
     * {@link Character#digit Character.digit}, prepending a negative sign (-)
     * if the locale specific negative prefixes and suffixes were present, and
     * passing the resulting string to
     * {@link Float#parseFloat Float.parseFloat}. If the token matches the
     * localized NaN or infinity strings, then either "Nan" or "Infinity" is
     * passed to {@link Float#parseFloat(String) Float.parseFloat} as
     * appropriate.
     *
     * @return the {@code float} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Float</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if input is exhausted
     * @throws IllegalStateException if this scanner is closed
     */
    public static float nextFloat() {
        return SCN.nextFloat();
    }

    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as a double value using the {@link #nextDouble} method. The scanner does
     * not advance past any input.
     *
     * @return true if and only if this scanner's next token is a valid double
     * value
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean hasNextDouble() {
        return SCN.hasNextDouble();
    }

    /**
     * Scans the next token of the input as a {@code double}. This method will
     * throw {@code InputMismatchException} if the next token cannot be
     * translated into a valid double value. If the translation is successful,
     * the scanner advances past the input that matched.
     *
     * <p>
     * If the next token matches the <a
     * href="#Float-regex"><i>Float</i></a> regular expression defined above
     * then the token is converted into a {@code double} value as if by removing
     * all locale specific prefixes, group separators, and locale specific
     * suffixes, then mapping non-ASCII digits into ASCII digits via
     * {@link Character#digit Character.digit}, prepending a negative sign (-)
     * if the locale specific negative prefixes and suffixes were present, and
     * passing the resulting string to
     * {@link Double#parseDouble Double.parseDouble}. If the token matches the
     * localized NaN or infinity strings, then either "Nan" or "Infinity" is
     * passed to {@link Double#parseDouble(String) Double.parseDouble} as
     * appropriate.
     *
     * @return the {@code double} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Float</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if the input is exhausted
     * @throws IllegalStateException if this scanner is closed
     */
    public static double nextDouble() {
        return SCN.nextDouble();
    }

    // Convenience methods for scanning multi precision numbers
    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as a {@code BigInteger} in the default radix using the
     * {@link #nextBigInteger} method. The scanner does not advance past any
     * input.
     *
     * @return true if and only if this scanner's next token is a valid
     * {@code BigInteger}
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean hasNextBigInteger() {
        return SCN.hasNextBigInteger();
    }

    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as a {@code BigInteger} in the specified radix using the
     * {@link #nextBigInteger} method. The scanner does not advance past any
     * input.
     *
     * <p>
     * If the radix is less than {@link Character#MIN_RADIX Character.MIN_RADIX}
     * or greater than {@link Character#MAX_RADIX Character.MAX_RADIX}, then an
     * {@code IllegalArgumentException} is thrown.
     *
     * @param radix the radix used to interpret the token as an integer
     * @return true if and only if this scanner's next token is a valid
     * {@code BigInteger}
     * @throws IllegalStateException if this scanner is closed
     * @throws IllegalArgumentException if the radix is out of range
     */
    public static boolean hasNextBigInteger(int radix) {
        return SCN.hasNextBigInteger(radix);
    }

    /**
     * Scans the next token of the input as a {@link java.math.BigInteger
     * BigInteger}.
     *
     * <p>
     * An invocation of this method of the form {@code nextBigInteger()} behaves
     * in exactly the same way as the invocation {@code nextBigInteger(radix)},
     * where {@code radix} is the default radix of this scanner.
     *
     * @return the {@code BigInteger} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Integer</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if the input is exhausted
     * @throws IllegalStateException if this scanner is closed
     */
    public static BigInteger nextBigInteger() {
        return SCN.nextBigInteger();
    }

    /**
     * Scans the next token of the input as a {@link java.math.BigInteger
     * BigInteger}.
     *
     * <p>
     * If the next token matches the <a
     * href="#Integer-regex"><i>Integer</i></a> regular expression defined above
     * then the token is converted into a {@code BigInteger} value as if by
     * removing all group separators, mapping non-ASCII digits into ASCII digits
     * via the {@link Character#digit Character.digit}, and passing the
     * resulting string to the {@link
     * java.math.BigInteger#BigInteger(java.lang.String)
     * BigInteger(String, int)} constructor with the specified radix.
     *
     * <p>
     * If the radix is less than {@link Character#MIN_RADIX Character.MIN_RADIX}
     * or greater than {@link Character#MAX_RADIX Character.MAX_RADIX}, then an
     * {@code IllegalArgumentException} is thrown.
     *
     * @param radix the radix used to interpret the token
     * @return the {@code BigInteger} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Integer</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if the input is exhausted
     * @throws IllegalStateException if this scanner is closed
     * @throws IllegalArgumentException if the radix is out of range
     */
    public static BigInteger nextBigInteger(int radix) {
        return SCN.nextBigInteger(radix);
    }

    /**
     * Returns true if the next token in this scanner's input can be interpreted
     * as a {@code BigDecimal} using the {@link #nextBigDecimal} method. The
     * scanner does not advance past any input.
     *
     * @return true if and only if this scanner's next token is a valid
     * {@code BigDecimal}
     * @throws IllegalStateException if this scanner is closed
     */
    public static boolean hasNextBigDecimal() {
        return SCN.hasNextBigDecimal();
    }

    /**
     * Scans the next token of the input as a {@link java.math.BigDecimal
     * BigDecimal}.
     *
     * <p>
     * If the next token matches the <a
     * href="#Decimal-regex"><i>Decimal</i></a> regular expression defined above
     * then the token is converted into a {@code BigDecimal} value as if by
     * removing all group separators, mapping non-ASCII digits into ASCII digits
     * via the {@link Character#digit Character.digit}, and passing the
     * resulting string to the {@link
     * java.math.BigDecimal#BigDecimal(java.lang.String) BigDecimal(String)}
     * constructor.
     *
     * @return the {@code BigDecimal} scanned from the input
     * @throws InputMismatchException if the next token does not match the
     * <i>Decimal</i>
     * regular expression, or is out of range
     * @throws NoSuchElementException if the input is exhausted
     * @throws IllegalStateException if this scanner is closed
     */
    public static BigDecimal nextBigDecimal() {
        return SCN.nextBigDecimal();
    }

    /**
     * Resets this scanner.
     *
     * <p>
     * Resetting a scanner discards all of its explicit state information which
     * may have been changed by invocations of
     * {@link #useDelimiter useDelimiter()}, {@link #useLocale useLocale()}, or
     * {@link #useRadix useRadix()}.
     *
     * <p>
     * An invocation of this method of the form {@code scanner.reset()} behaves
     * in exactly the same way as the invocation
     *
     * <blockquote><pre>{@code
     *   scanner.useDelimiter("\\p{javaWhitespace}+")
     *          .useLocale(Locale.getDefault(Locale.Category.FORMAT))
     *          .useRadix(10);
     * }</pre></blockquote>
     *
     * @return this scanner
     *
     * @since 1.6
     */
    public static Scanner reset() {
        return SCN.reset();
    }

    /**
     * Returns a stream of delimiter-separated tokens from this scanner. The
     * stream contains the same tokens that would be returned, starting from
     * this scanner's current state, by calling the {@link #next} method
     * repeatedly until the {@link #hasNext} method returns false.
     *
     * <p>
     * The resulting stream is sequential and ordered. All stream elements are
     * non-null.
     *
     * <p>
     * Scanning starts upon initiation of the terminal stream operation, using
     * the current state of this scanner. Subsequent calls to any methods on
     * this scanner other than {@link #close} and {@link #ioException} may
     * return undefined results or may cause undefined effects on the returned
     * stream. The returned stream's source {@code Spliterator} is
     * <em>fail-fast</em> and will, on a best-effort basis, throw a
     * {@link java.util.ConcurrentModificationException} if any such calls are
     * detected during stream pipeline execution.
     *
     * <p>
     * After stream pipeline execution completes, this scanner is left in an
     * indeterminate state and cannot be reused.
     *
     * <p>
     * If this scanner contains a resource that must be released, this scanner
     * should be closed, either by calling its {@link #close} method, or by
     * closing the returned stream. Closing the stream will close the underlying
     * scanner. {@code IllegalStateException} is thrown if the scanner has been
     * closed when this method is called, or if this scanner is closed during
     * stream pipeline execution.
     *
     * <p>
     * This method might block waiting for more input.
     *
     * @apiNote For example, the following code will create a list of
     * comma-delimited tokens from a string:
     *
     * <pre>{@code
     * List<String> result = new Scanner("abc,def,,ghi")
     *     .useDelimiter(",")
     *     .tokens()
     *     .collect(Collectors.toList());
     * }</pre>
     *
     * <p>
     * The resulting list would contain {@code "abc"}, {@code "def"}, the empty
     * string, and {@code "ghi"}.
     *
     * @return a sequential stream of token strings
     * @throws IllegalStateException if this scanner is closed
     * @since 9
     */
    public static Stream<String> tokens() {
        return SCN.tokens();
    }

    /**
     * Returns a stream of match results from this scanner. The stream contains
     * the same results in the same order that would be returned by calling
     * {@code findWithinHorizon(pattern, 0)} and then {@link #match}
     * successively as long as {@link #findWithinHorizon findWithinHorizon()}
     * finds matches.
     *
     * <p>
     * The resulting stream is sequential and ordered. All stream elements are
     * non-null.
     *
     * <p>
     * Scanning starts upon initiation of the terminal stream operation, using
     * the current state of this scanner. Subsequent calls to any methods on
     * this scanner other than {@link #close} and {@link #ioException} may
     * return undefined results or may cause undefined effects on the returned
     * stream. The returned stream's source {@code Spliterator} is
     * <em>fail-fast</em> and will, on a best-effort basis, throw a
     * {@link java.util.ConcurrentModificationException} if any such calls are
     * detected during stream pipeline execution.
     *
     * <p>
     * After stream pipeline execution completes, this scanner is left in an
     * indeterminate state and cannot be reused.
     *
     * <p>
     * If this scanner contains a resource that must be released, this scanner
     * should be closed, either by calling its {@link #close} method, or by
     * closing the returned stream. Closing the stream will close the underlying
     * scanner. {@code IllegalStateException} is thrown if the scanner has been
     * closed when this method is called, or if this scanner is closed during
     * stream pipeline execution.
     *
     * <p>
     * As with the {@link #findWithinHorizon findWithinHorizon()} methods, this
     * method might block waiting for additional input, and it might buffer an
     * unbounded amount of input searching for a match.
     *
     * @apiNote For example, the following code will read a file and return a
     * list of all sequences of characters consisting of seven or more Latin
     * capital letters:
     *
     * <pre>{@code
     * try (Scanner sc = new Scanner(Path.of("input.txt"))) {
     *     Pattern pat = Pattern.compile("[A-Z]{7,}");
     *     List<String> capWords = sc.findAll(pat)
     *                               .map(MatchResult::group)
     *                               .collect(Collectors.toList());
     * }
     * }</pre>
     *
     * @param pattern the pattern to be matched
     * @return a sequential stream of match results
     * @throws NullPointerException if pattern is null
     * @throws IllegalStateException if this scanner is closed
     * @since 9
     */
    public static Stream<MatchResult> findAll(Pattern pattern) {
        return SCN.findAll(pattern);
    }

    /**
     * Returns a stream of match results that match the provided pattern string.
     * The effect is equivalent to the following code:
     *
     * <pre>{@code
     *     scanner.findAll(Pattern.compile(patString))
     * }</pre>
     *
     * @param patString the pattern string
     * @return a sequential stream of match results
     * @throws NullPointerException if patString is null
     * @throws IllegalStateException if this scanner is closed
     * @throws PatternSyntaxException if the regular expression's syntax is
     * invalid
     * @since 9
     * @see java.util.regex.Pattern
     */
    public static Stream<MatchResult> findAll(String patString) {
        return SCN.findAll(patString);
    }
}
