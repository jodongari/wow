/** @type {import('next').NextConfig} */
module.exports = {
  reactStrictMode: true,

  async rewrites() {
    return [
      {
        source: '/:path*',
        destination: `${process.env.BACKEND_API_SERVER}:path*`,
      },
    ]
  },
}
