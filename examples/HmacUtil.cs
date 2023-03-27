using System.Security.Cryptography;

namespace Hmac
{
    public class HmacUtil
      {
        private string hmacSha512(string message, string secret)
        {
          secret = secret ?? "";
          var encoding = new System.Text.ASCIIEncoding();
          byte[] keyByte = encoding.GetBytes(secret);
          byte[] messageBytes = encoding.GetBytes(message);

          using (var hmacSha512 = new HMACSHA512(keyByte))
          {
            byte[] hashmessage = hmacSha512.ComputeHash(messageBytes);
            return Convert.ToBase64String(hashmessage);
          }
        }
      }
}
