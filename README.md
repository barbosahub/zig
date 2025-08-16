# Zig

<img width="324" height="720" alt="image" src="https://github.com/user-attachments/assets/28466e02-8d80-46a3-b3fc-89ea115f6898" />

## Estrutura do projeto Kotlin / Android

Projeto modularizado com módulos bem definidos para facilitar manutenção, escalabilidade e reuso de código.

```text
├── core                       # Código compartilhado entre todos os módulos (feature). Contém lógica, estados, componentes e utilitários reutilizáveis.
│   ├── data                   # Fonte de dados genérica para todos os módulos
│   │   ├── local               # Repositórios locais, banco de dados, SharedPreferences
│   │   ├── network             # DTOs, APIs e camada de requisição de rede
│   │   ├── repository          # Repositórios genéricos compartilhados
│   │   └── mapper              # Mapeamento entre DTOs e Models
│   │
│   ├── domain
│   │   ├── model               # Models compartilhados
│   │   └── repository          # Interfaces de repositórios compartilhados
│   │
│   └── presentation
│       ├── ui                  # Componentes de UI compartilhados
│       ├── viewmodel           # ViewModels genéricos ou base
│       └── state               # Estados compartilhados
│
├── features                    # Módulos específicos de cada funcionalidade
│   ├── comics                  # Exemplo de módulo feature
│   │   ├── data
│   │   │   ├── local           # Repositórios locais específicos do módulo
│   │   │   ├── network         # DTOs e APIs específicas do módulo
│   │   │   └── repository      # Repositórios do módulo
│   │   │
│   │   ├── domain
│   │   │   ├── model           # Models específicos do módulo
│   │   │   └── repository      # Interfaces de repositórios do módulo
│   │   │
│   │   └── presentation
│   │       ├── action          # Ações de UI, ex: clique em botão
│   │       ├── components      # Componentes de UI específicos do módulo
│   │       ├── event           # Eventos de navegação e interações
│   │       ├── screen          # Telas do módulo
│   │       ├── state           # Estados específicos do módulo
│   │       └── viewmodel       # ViewModels do módulo
│   │
│   └── outraFeature
│       └── ... (mesma estrutura)
│
├── di                          # Configuração de injeção de dependências (Koin)
├── utils                       # Extensões, helpers, constantes e utilitários gerais
└── App.kt                       # Classe Application

