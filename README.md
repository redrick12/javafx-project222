# JavaFX Project
Projeto JavaFX de um totem de cinema utilizando o Maven.

## Como executar

Fazer o clone do repositório, abrir a pasta src, main, com e por fim o arquivo cinematotem, dar debug e rodar.

Remover a pasta .git:
```bash
rm -rf .git
```

Iniciar um repositório git, fazer commits e enviar para o seu repositório remoto.


Nos laboratórios de informática do IFSP é necessário configurar o proxy para o funcionamento do maven:

```bash
export JAVA_TOOL_OPTIONS="-Djava.net.useSystemProxies=true"
```

No mesmo terminal que foi configurado o proxy executar o comando:
```bash
./mvnw javafx:run
```
É de suma importância que a máquina na qual o código rode, possua extensões java e javafx instaladas. C
