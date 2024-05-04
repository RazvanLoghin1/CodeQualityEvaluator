# Code Quality Evaluator

The Code Quality Evaluator is a Java and Kotlin code analysis tool designed to evaluate basic aspects of code quality within a codebase. It analyzes methods/functions in Java and Kotlin files, providing insights into method complexity and adherence to coding standards.

## Features

- **Method Complexity Evaluation**: Calculates the complexity of methods based on control flow elements such as `if`, `for`, `while`, `switch`, and `case` statements.
- **Code Style Check**: Performs a simple code style check to ensure that method names adhere to the camelCase naming conventions.
- **Supports Java and Kotlin**: Analyzes both Java and Kotlin files for comprehensive code quality evaluation.

## Requirements

- Java Development Kit (JDK) 8 or higher
- IntelliJ IDEA or any Java-compatible IDE

## Installation

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/RazvanLoghin1/CodeQualityEvaluator.git
    ```

2. Open the project in your preferred Java-compatible IDE.

## Directory Structure

The project includes a specially prepared directory containing example Java and Kotlin files. These files have been crafted with various levels of complexity and different coding styles to facilitate testing the efficiency and correctness of the tool:

- **src**:
   - **com**: Contains the main application classes.
      - `CodeQualityEvaluator.java`
      - `MethodAnalyzer.java`
   - **filesToTest**: Contains sample Java and Kotlin files for testing.
      - **javaFiles**: Example Java files.
      - **kotlinFiles**: Example Kotlin files.
   - **Testing**: Contains testing classes.
      - `BufferedReaderMock.java`
      - `unitTests.java`

## Usage

1. Run the `CodeQualityEvaluator` class.
2. When prompted, enter the path to the directory containing Java and Kotlin files.
3. The tool will analyze the files and provide the following insights:
   - Top 3 methods by complexity.
   - Percentage of methods not following camelCase naming convention.

## Example

```bash
Please enter the path to the directory containing Java and Kotlin files:
/path/to/your/directory
```

## Testing

Unit tests have been provided to ensure the functionality and reliability of the application. You can run these tests by executing the `unitTests` class within your IDE or via a command-line interface. This will test both the functionality of the application and the integration with the provided Java and Kotlin example files.

## Contributing

Contributions are welcome! Feel free to open issues or pull requests for any improvements or bug fixes.

## Learning and Initiative

In developing this project, I've applied my existing knowledge as well as learning and researching needed skills for the completion of this project. Here's how I approached learning and applied my skills:

- **Understanding Code Quality Metrics:** I started by researching and understanding various code quality metrics such as method complexity and coding standards. This involved reading articles and studying best practices in software engineering.
- **Java and Kotlin Proficiency:** As the project required analyzing both Java and Kotlin code, I leveraged my existing knowledge of these languages. I ensured that I understood the syntax and features specific to each language to implement the analysis algorithms effectively.
- **Regular Expressions:** Since the project involved pattern matching to identify method signatures in code files, I developed my skills in regular expressions. I studied various regex patterns and experimented with them to ensure accurate matching of method signatures.
- **Handling File Operations:** The project required reading files from the filesystem, so I familiarized myself with Java's java.nio.file package. I learned how to traverse directories, filter files, and read file contents efficiently.
- **Testing and Debugging:** Throughout the development process, I employed testing and debugging techniques to ensure the correctness and robustness of the code.

---

This README provides a brief overview of the Code Quality Evaluator tool, its features, installation instructions, usage guide, testing instructions, and contribution guidelines. For more detailed information, refer to the codebase and its documentation.

Happy coding! 🚀