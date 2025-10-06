<?php
    require_once 'vendor/autoload.php';

    use Monolog\Logger;
    use Monolog\Handler\StreamHandler;

    class Meulogger {
        private $logger;

        public function __construct() {
            $this->logger = new Logger("meu-app");
            $this->logger->pushHandler(new StreamHandler('app.log', Logger::DEBUG));
        }
        public function logInfo($message) {
            $this->logger->info($message);
        }
        public function logError($message) {
            $this->logger->error($message);
        }
    }

    $logger = new Meulogger();
    $logger->logError("Erro na conexão com o banco!");
    $logger->logInfo("Aplicação iniciada!");
?>