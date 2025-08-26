# E2EE_Chat

---

## 📋 Indice
- [Descrizione](#descrizione)
- [Installazione e uso](#Installazioneeuso)

---


## Descrizione 📝
Questo progetto è un’applicazione **client/server** che consente la comunicazione tramite una **chat con crittografia End-to-End (E2EE)**.  

La fase iniziale prevede la connessione di due client a un server tramite **socket**. Il server ha il solo scopo di fungere da **proxy** per le comunicazioni, senza mai accedere ai messaggi in chiaro.

La **negoziazione delle chiavi** avviene attraverso il protocollo **Diffie-Hellman (DH)**:
- Vengono scelti in tempo reale i parametri di DH (p, g, chiavi pubbliche e private).  
- Ogni client calcola la chiave condivisa che verrà usata per cifrare i messaggi scambiati.  

Il server, in quanto **relay server**, visualizza in tempo reale il processo di scambio chiavi e l’invio dei messaggi **cifrati**, ma non ha accesso al loro contenuto in chiaro.

Il progetto è sviluppato interamente in Java.

---

## Installazione e uso 🚀


1. **Compila il progetto**

   Compila tutti i file sorgente e genera i file `.class` nella cartella `bin`:
   ```sh
   javac -d e2ee_chat/bin e2ee_chat/src/**/*.java
   ```

2. **Avvia il server**

   ```sh
   java -cp "bin:lib/*" e2ee_chat.Server
   ```

3. **Avvia i client**

   In finestre terminali separate:
   ```sh
   java -cp "bin:lib/*" e2ee_chat.Client <indirizzo_ip_del_server> <porta>
   ```
---






