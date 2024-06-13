import http from "k6/http"
import { check } from "k6"

export let options = {
  stages: [
    { duration: '3s', target: 6 },
    { duration: '10s', target: 40 },
    { duration: '30s', target: 80 },
    { duration: '10s', target: 2 },
    { duration: '5s', target: 50 },
    { duration: '30s', target: 100 },
    { duration: '2s', target: 1 },
    { duration: '20s', target: 200 },
    { duration: '2s', target: 2 },
  ],
  thresholds: {
    http_req_failed: ['rate < 0.02'],
    http_req_duration: ['p(95) < 100']
  }
}

export default function(){
  
  const endpoint = 'endpoint-da-sua-api';
  
  const response = http.get(endpoint)

  check(response, {
    'Sucesso':(r) => r.status === 200
  })
}