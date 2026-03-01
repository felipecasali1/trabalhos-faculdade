const { JsonDB, Config } = require('node-json-db');

async function inserir(user) {
    const db = new JsonDB(new Config("data", true, true, '/'));
    if (user instanceof Object && "name" in user) {
        let users = await db.getData(`/users/list`);
        let lastId = 0;
        for (let user of users) {
            if (user === null) continue;
            if (Number(user.id) > lastId) {
                lastId = Number(user.id);
            }
        }
        await db.push("/users/list[]", { id: lastId + 1, name: user.name });
        console.log("Usuário inserido!");
        return true;
    }
    return false;
}

async function remover(userId) {
    const db = new JsonDB(new Config("data", true, true, '/'));

    if (!isNaN(userId)) {
        let users = await db.getData(`/users/list`);
        let index = 0;
        for (let user of users) {
            if (user === null) {
                index++;
                continue;
            }
            if (Number(user.id) === Number(userId)) {
                await db.delete(`/users/list/${index}`);
                users = await db.getData(`/users/list`);
                db.push(`/users/list`, users.filter(obj => obj != null), true);
                console.log("Usuário removido!");
                return true;
            }
            index++;
        }
    }
    return false;
}

async function procurar(userId) {
    const db = new JsonDB(new Config("data", true, true, '/'));

    if (!isNaN(userId)) {
        let users = await db.getData(`/users/list`);
        for (let user of users) {
            if (user === null) continue;
            if (Number(user.id) === Number(userId)) {
                console.log("Usuário encontrado!");
                return user;
            }
        }
    }
    return null;
}

// (async () => {
//     let usr = await procurar(1);
//     console.log(usr);
// })();

module.exports = { inserir, remover, procurar }