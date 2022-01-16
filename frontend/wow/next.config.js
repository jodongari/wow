/** @type {import('next').NextConfig} */
module.exports = {
  reactStrictMode: true,

  async rewrites() {
    return [
      {
        // source: /api/~ 로 시작되는 모든 API를 destination(localhost:8080/~) 으로 전달
        // 추후 'api'를 API 컨벤션 회의를 통해 변경해야 합니다.
        source: '/api/:path*',
        destination: `${process.env.BACKEND_API_SERVER}:path*`,
      },
    ]
  },
}
