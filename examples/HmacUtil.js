const crypto = require('crypto');

function hmacSha512(secret, message) {
    const key = new Buffer(secret, 'utf8');

    return crypto.createHmac('sha512', key)
        .update(message)
        .digest()
        .toString('base64');
}
