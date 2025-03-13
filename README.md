# ASCII Art Converter

A Java library that converts images into ASCII art. This project uses Maven for dependency management and is published on GitHub Packages.

## Features
- Simple integration into Java projects
- Lightweight and efficient implementation

## Installation

Add the dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.ilya.asciiart</groupId>
    <artifactId>asciiart-lib</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

Make sure to configure GitHub Packages in your `settings.xml`:

```xml
<server>
    <id>github</id>
    <username>your-github-username</username>
    <password>your-github-personal-access-token</password>
</server>
```

## Usage

```java
import com.ilya.asciiart.ASCIIArt;

public class Main {
    public static void main(String[] args) {
        char[][] ch = ASCIIArt.convert("filePath");
    }
}
```

## Contributing
Feel free to open issues and submit pull requests. Contributions are welcome!

## License
This project is licensed under the MIT License.
