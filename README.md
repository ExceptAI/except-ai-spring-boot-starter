# 🚀 ExceptAI Spring Boot Starter

Zero-configuration error monitoring with AI-powered analysis for Spring Boot applications.

## ✨ Features

- ✅ **Zero Configuration** - Just add the dependency and configure API key
- ✅ **Automatic Error Capture** - Catches all exceptions via `@ControllerAdvice`
- ✅ **HTTP Context** - Captures full request details (URL, headers, method, IP)
- ✅ **Git SHA Detection** - Automatically detects commit from CI/CD env vars
- ✅ **AI Analysis** - Get instant AI-powered error explanations
- ✅ **Spring Boot 3.x** - Compatible with latest Spring Boot

## 📦 Installation

### Step 1: Add JitPack repository

Add to your `pom.xml`:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

### Step 2: Add dependency
```xml
<dependency>
    <groupId>com.github.ExceptAI</groupId>
    <artifactId>except-ai-spring-boot-starter</artifactId>
    <version>1.0.1</version>
</dependency>
```

### Step 3: Configure

Add to your `application.yml`:
```yaml
except-ai:
  enabled: true
  api-key: "your-api-key-here"
  endpoint: "https://api.exceptai.com/v1/errors"
  service: "my-application"
  environment: "production"
```

## 🎯 Configuration Options

| Property | Required | Default | Description |
|----------|----------|---------|-------------|
| `except-ai.enabled` | No | `true` | Enable/disable error tracking |
| `except-ai.api-key` | **Yes** | - | Your ExceptAI API key |
| `except-ai.endpoint` | No | `http://localhost:8080/api/v1/errors` | ExceptAI API endpoint |
| `except-ai.service` | No | `unknown` | Service name |
| `except-ai.environment` | No | `production` | Environment (dev/staging/production) |

## 🔑 Getting API Key

1. Sign up at [ExceptAI](https://exceptai.com) (coming soon)
2. Create a new project
3. Copy your API key
4. Add to `application.yml`

## 🧪 Testing

Trigger a test error:
```java
@RestController
public class TestController {
    
    @GetMapping("/test-error")
    public String testError() {
        throw new RuntimeException("Test error from ExceptAI!");
    }
}
```

Visit: `http://localhost:8080/test-error`

Your error will automatically be sent to ExceptAI with:
- Full stack trace
- HTTP request details
- AI-powered analysis
- Link to source code (if GitHub connected)

## 🔒 Security

- Sensitive headers (Authorization, Cookie, API keys) are **automatically redacted**
- Request body is **never sent** (may contain passwords)
- Query parameters containing "password", "token", "secret" are **redacted**

## 🌐 Supported CI/CD

Git SHA is automatically detected from:
- ✅ GitHub Actions (`GITHUB_SHA`)
- ✅ GitLab CI (`CI_COMMIT_SHA`)
- ✅ Jenkins (`GIT_COMMIT`)
- ✅ CircleCI (`CIRCLE_SHA1`)

## 📊 What Gets Sent
```json
{
  "timestamp": "2025-11-15T10:30:00Z",
  "service": "my-app",
  "environment": "production",
  "gitSha": "abc123...",
  "exception": {
    "type": "NullPointerException",
    "message": "Cannot invoke toString() on null",
    "stackTrace": "..."
  },
  "http": {
    "method": "GET",
    "url": "https://api.example.com/users",
    "headers": { "user-agent": "..." },
    "remoteAddr": "192.168.1.1"
  }
}
```

## 🤝 Contributing

Contributions are welcome! Please open an issue or PR.

## 📄 License

MIT License

## 🔗 Links

- [ExceptAI Dashboard](https://exceptai.com)
- [Documentation](https://docs.exceptai.com)
- [GitHub](https://github.com/ExceptAI/except-ai-spring-boot-starter)

---

Made with ❤️ by ExceptAI
